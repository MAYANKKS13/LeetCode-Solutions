package org.example.BinaryTreeGeneral;


public class TreeNode {
          public int val;
          public TreeNode left;
          public TreeNode right;


          public void TreeNode() {}

          public TreeNode(int val) { this.val = val; }

          public void TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
}
