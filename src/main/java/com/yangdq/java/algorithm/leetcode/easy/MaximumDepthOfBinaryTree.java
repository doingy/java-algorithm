package com.yangdq.java.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree
 */
public class MaximumDepthOfBinaryTree {
    private static Logger logger = LoggerFactory.getLogger(MaximumDepthOfBinaryTree.class);

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 迭代
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }

        return ans;
    }

    // 递归
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        logger.info("" + solution.maxDepth(null));
    }
}
