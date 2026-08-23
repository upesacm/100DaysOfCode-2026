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
    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }

        int value = preorder[index];

        // Value doesn't belong in this subtree
        if (value <= lower || value >= upper) {
            return null;
        }

        index++;

        TreeNode root = new TreeNode(value);

        // Left subtree: values < root
        root.left = build(preorder, lower, value);

        // Right subtree: values > root
        root.right = build(preorder, value, upper);

        return root;
    }
}