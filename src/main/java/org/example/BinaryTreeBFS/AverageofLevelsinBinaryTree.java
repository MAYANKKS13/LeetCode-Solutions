package org.example.BinaryTreeBFS;

/*
637. Average of Levels in Binary Tree

Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [3.00000,14.50000,11.00000]
Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
Hence return [3, 14.5, 11].

Example 2:

Input: root = [3,9,20,15,7]
Output: [3.00000,14.50000,11.00000]
 */

import org.example.BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            double sum = 0;
            double avg = 0;
            int n = 0;
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                n = n + 1;
                TreeNode temp = bfsQueue.poll();
                sum = sum + temp.val;
                if (temp.right != null)
                    bfsQueue.add(temp.right);
                if (temp.left != null)
                    bfsQueue.add(temp.left);
            }
            avg = sum/n;
            result.add(avg);
        }
        return result;
    }
}
