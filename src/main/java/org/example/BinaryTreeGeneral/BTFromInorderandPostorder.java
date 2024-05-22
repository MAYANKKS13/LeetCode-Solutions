package org.example.BinaryTreeGeneral;

public class BTFromInorderandPostorder {
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        int end = inorder.length - 1;
        TreeNode root = buildTreeHelper(postorder, inorder, 0, end);
        return root;
    }

    public TreeNode buildTreeHelper(int[] postOrder, int[] inOrder, int start, int end){
        if(start > end){
            return null;
        }
        TreeNode root = new TreeNode(postOrder[index--]);

        int ind = search(inOrder, start, end, root.val);
        root.right = buildTreeHelper(postOrder, inOrder, ind + 1, end);
        root.left = buildTreeHelper(postOrder, inOrder, start, ind - 1);


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
