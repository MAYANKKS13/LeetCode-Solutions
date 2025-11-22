package org.example.BinaryTreeGeneral;

/*
101. Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:

Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:

Input: root = [11,2,2,null,3,null,3]
Output: false
 */

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        }
        return (leftRoot.val == rightRoot.val) && isMirror(leftRoot.left, rightRoot.right) && isMirror(leftRoot.right, rightRoot.left);
    }
}
