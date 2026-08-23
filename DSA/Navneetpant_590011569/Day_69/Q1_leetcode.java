/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return formBST (preorder , 0 , preorder.length-1);
    
    }
    public TreeNode formBST (int [] arr , int left , int right) {
        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode (arr [left]);

        int i = left + 1;

        while (i <= right && arr[i] < arr[left]) {
            i++;
        }


        root.left = formBST (arr, left+1 , i-1);
        root.right = formBST (arr , i, right);
        return root;
    }
}