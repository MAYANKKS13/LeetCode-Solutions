package org.example.BinarySearchTree;

/*
230. Kth Smallest Element in a BST

Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:

Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3
 */

import org.example.BinaryTreeGeneral.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list = inOrder(root, result);
        return list.get(k-1);

    }
    public List<Integer> inOrder(TreeNode root, List<Integer> result){
        if(root != null){
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
        return result;
    }
}
