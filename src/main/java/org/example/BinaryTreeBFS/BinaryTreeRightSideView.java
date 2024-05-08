package org.example.BinaryTreeBFS;

/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:

Input: root = [1,null,3]
Output: [1,3]

Example 3:

Input: root = []
Output: []
 */

import org.example.BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            // List<Integer> level = new ArrayList<>();
            int size = bfsQueue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = bfsQueue.poll();
                if(i ==0){
                    result.add(temp.val);
                }
                if (temp.right != null)
                    bfsQueue.add(temp.right);
                if (temp.left != null)
                    bfsQueue.add(temp.left);
            }
        }
        return result;
    }
}
