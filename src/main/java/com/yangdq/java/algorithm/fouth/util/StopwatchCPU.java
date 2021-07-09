package com.yangdq.java.algorithm.fouth.util;

import java.lang.management.ThreadMXBean;
import java.lang.management.ManagementFactory;

/**
 * https://introcs.cs.princeton.edu/java/stdlib/StopwatchCPU.java.html
 */
public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public StopwatchCPU() {
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }
}
