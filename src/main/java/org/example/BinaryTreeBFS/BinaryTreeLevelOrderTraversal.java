package org.example.BinaryTreeBFS;

/*
102. Binary Tree Level Order Traversal

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:

Input: root = [1]
Output: [[1]]
 */

import org.example.BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = bfsQueue.poll();
                level.add(temp.val);
                if (temp.left != null)
                    bfsQueue.add(temp.left);
                if (temp.right != null)
                    bfsQueue.add(temp.right);
            }
            result.add(level);
        }
        return result;
    }
}
