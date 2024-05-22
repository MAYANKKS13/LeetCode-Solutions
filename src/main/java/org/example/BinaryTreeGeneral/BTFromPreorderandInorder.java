package org.example.BinaryTreeGeneral;

/*
105. Construct Binary Tree from Preorder and Inorder Traversal

Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:

Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 */

public class BTFromPreorderandInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int end = inorder.length - 1;
        TreeNode root = buildTreeHelper(preorder, inorder, 0, end);
        return root;

    }

    private int index = 0;

    public TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(preOrder[index++]);

        int ind = search(inOrder, start, end, root.val);
        root.left = buildTreeHelper(preOrder, inOrder, start, ind - 1);
        root.right = buildTreeHelper(preOrder, inOrder, ind + 1, end);

        return root;
    }

    public int search(int[] inorder, int start, int end, int value){
        for(int i = start; i <= end; i++){
            if(inorder[i] == value){
                return i;
            }
        }
        return -1;
    }
}
