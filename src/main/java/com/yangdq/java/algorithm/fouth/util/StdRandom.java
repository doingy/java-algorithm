package com.yangdq.java.algorithm.fouth.util;

import java.util.Random;

/**
 * https://introcs.cs.princeton.edu/java/22library/StdRandom.java.html
 */
public class StdRandom {
    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    private StdRandom() {

    }

    public static void setSeed(long s) {
        seed = s;
        random = new Random(seed);
    }

    public static long getSeed() {
        return seed;
    }

    /**
     * 0 - 1之间的实数 [0, 1)
     */
    public static double uniform() {
        return random.nextDouble();
    }

    /**
     * 0 - n-1 之间的整数 [0, n)
     */
    public static int uniform(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("argument must be positive: " + n);
        }
        return n - 1;
    }

    /**
     * 0 - n-1 之间的整数 [0, n)
     */
    public static long uniform(long n) {
        if (n <= 0L) {
            throw new IllegalArgumentException("argument must be positive: " + n);
        }

        long r = random.nextLong();
        long m = n - 1;

        if ((n & m) == 0L) {
            return r & m;
        }

        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) {
            u = random.nextLong() >>> 1;
        }
        return r;
    }

    /**
     * lo - hi 之间的整数
     */
    public static int uniform(int lo, int hi) {
        if ((hi <= lo) || ((long) hi - lo >= Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("invalid range: [" + lo + ", " + hi + ")");
        }
        return lo + uniform(hi - lo);
    }

    /**
     * lo - hi 之间的实数
     */
    public static double uniform(double lo, double hi) {
        if (hi < lo) {
            throw new IllegalArgumentException("invalid range: [" + lo + ", " + hi + ")");
        }
        return lo + uniform() * (hi - lo);
    }

    /**
     * 返回真的概率为p
     */
    public static boolean bernoulli(double p) {
        if (p < 0.0 || p > 1.0) {
            throw new IllegalArgumentException("probability p must be between 0.0 and 1.0: " + p);
        }
        return uniform() < p;
    }

    /**
     * 返回真的概率
     */
    public static boolean bernoulli() {
        return bernoulli(0.5);
    }

    /**
     * 正态分布，期望值为0，标准差为1
     */
    public static double gaussian() {
        double r, x, y;
        do {
            x = uniform(-1.0, 1.0);
            y = uniform(-1.0, 1.0);
            r = x * x + y * y;
        } while (r >= 1 || r == 0);
        return x * Math.sqrt(-2 * Math.log(r) / r);
    }

    /**
     * 正态分布，期望值为m，标准差为s
     */
    public static double gaussian(double m, double s) {
        return m + s * gaussian();
    }

    public static int geometric(double p) {
        if (!(p >= 0)) {
            throw new IllegalArgumentException("probability p must be greater than 0: " + p);
        }
        if (!(p <= 1.0)) {
            throw new IllegalArgumentException("probability p must not be larger than 1: " + p);
        }
        // using algorithm given by Knuth
        return (int) Math.ceil(Math.log(uniform()) / Math.log(1.0 - p));
    }

    public static int poisson(double lambda) {
        if (!(lambda > 0.0)) {
            throw new IllegalArgumentException("lambda must be positive: " + lambda);
        }
        if (Double.isInfinite(lambda)) {
            throw new IllegalArgumentException("lambda must not be infinite: " + lambda);
        }
        // using algorithm given by Knuth
        // see http://en.wikipedia.org/wiki/Poisson_distribution
        int k = 0;
        double p = 1.0;
        double expLambda = Math.exp(-lambda);
        do {
            k++;
            p *= uniform();
        } while (p >= expLambda);
        return k - 1;
    }

    public static double pareto() {
        return pareto(1.0);
    }

    public static double pareto(double alpha) {
        if (!(alpha > 0.0)) {
            throw new IllegalArgumentException("alpha must be positive: " + alpha);
        }
        return Math.pow(1 - uniform(), -1.0 / alpha) - 1.0;
    }

    public static double cauchy() {
        return Math.tan(Math.PI * (uniform() - 0.5));
    }

    /**
     * 返回i的概率为a[i]
     */
    public static int discrete(double[] probabilities) {
        if (probabilities == null) {
            throw new IllegalArgumentException("argument array must not be null");
        }
        double EPSILON = 1.0E-14;
        double sum = 0.0;
        for (int i = 0; i < probabilities.length; i++) {
            if (!(probabilities[i] >= 0.0)) {
                throw new IllegalArgumentException("array entry " + i + " must be non-negative: " + probabilities[i]);
            }
            sum += probabilities[i];
        }
        if (sum > 1.0 + EPSILON || sum < 1.0 - EPSILON) {
            throw new IllegalArgumentException("sum of array entries does not approximately equal 1.0: " + sum);
        }

        // the for loop may not return a value when both r is (nearly) 1.0 and when the
        // cumulative sum is less than 1.0 (as a result of floating-point roundoff error)
        while (true) {
            double r = uniform();
            sum = 0.0;
            for (int i = 0; i < probabilities.length; i++) {
                sum = sum + probabilities[i];
                if (sum > r) {
                    return i;
                }
            }
        }
    }

    public static int discrete(int[] frequencies) {
        if (frequencies == null) {
            throw new IllegalArgumentException("argument array must not be null");
        }
        long sum = 0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] < 0) {
                throw new IllegalArgumentException("array entry " + i + " must be non-negative: " + frequencies[i]);
            }
            sum += frequencies[i];
        }
        if (sum == 0) {
            throw new IllegalArgumentException("at least one array entry must be positive");
        }
        if (sum >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("sum of frequencies overflows an int");
        }

        // pick index i with probabilitity proportional to frequency
        double r = uniform((int) sum);
        sum = 0;
        for (int i = 0; i < frequencies.length; i++) {
            sum += frequencies[i];
            if (sum > r) {
                return i;
            }
        }

        // can't reach here
        assert false;
        return -1;
    }

    public static double exp(double lambda) {
        if (!(lambda > 0.0)) {
            throw new IllegalArgumentException("lambda must be positive: " + lambda);
        }
        return -Math.log(1 - uniform()) / lambda;
    }

    public static void shuffle(Object[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * 将数组a随机排序
     */
    public static void shuffle(double[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(char[] a) {
        validateNotNull(a);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniform(n - i);     // between i and n-1
            char temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(Object[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);     // between i and hi-1
            Object temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(double[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);     // between i and hi-1
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void shuffle(int[] a, int lo, int hi) {
        validateNotNull(a);
        validateSubarrayIndices(lo, hi, a.length);

        for (int i = lo; i < hi; i++) {
            int r = i + uniform(hi - i);     // between i and hi-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static int[] permutation(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative: " + n);
        }
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        shuffle(perm);
        return perm;
    }

    public static int[] permutation(int n, int k) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative: " + n);
        }
        if (k < 0 || k > n) {
            throw new IllegalArgumentException("k must be between 0 and n: " + k);
        }
        int[] perm = new int[k];
        for (int i = 0; i < k; i++) {
            int r = uniform(i + 1);    // between 0 and i
            perm[i] = perm[r];
            perm[r] = i;
        }
        for (int i = k; i < n; i++) {
            int r = uniform(i + 1);    // between 0 and i
            if (r < k) {
                perm[r] = i;
            }
        }
        return perm;
    }

    private static void validateNotNull(Object x) {
        if (x == null) {
            throw new IllegalArgumentException("argument must not be null");
        }
    }

    private static void validateSubarrayIndices(int lo, int hi, int length) {
        if (lo < 0 || hi > length || lo > hi) {
            throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt("721");
        if (args.length == 2) {
            StdRandom.setSeed(Long.parseLong(args[1]));
        }
        double[] probabilities = {0.5, 0.3, 0.1, 0.1};
        int[] frequencies = {5, 3, 1, 1};
        String[] a = "A B C D E F G".split(" ");

        StdOut.println("seed = " + StdRandom.getSeed());
        for (int i = 0; i < n; i++) {
            StdOut.printf("%2d ", uniform(100));
            StdOut.printf("%8.5f ", uniform(10.0, 99.0));
            StdOut.printf("%5b ", bernoulli(0.5));
            StdOut.printf("%7.5f ", gaussian(9.0, 0.2));
            StdOut.printf("%1d ", discrete(probabilities));
            StdOut.printf("%1d ", discrete(frequencies));
            StdOut.printf("%11d ", uniform(100000000000L));
            StdRandom.shuffle(a);
            for (String s : a) {
                StdOut.print(s);
            }
            StdOut.println();
        }
    }
}
