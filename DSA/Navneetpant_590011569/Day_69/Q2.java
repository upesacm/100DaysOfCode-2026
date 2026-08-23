class Solution {
    public TreeNode[] splitBST(TreeNode root, int target) {

        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (root.val <= target) {

            TreeNode[] result = splitBST(root.right, target);

            root.right = result[0];

            return new TreeNode[]{root, result[1]};

        } else {

            TreeNode[] result = splitBST(root.left, target);

            root.left = result[1];

            return new TreeNode[]{result[0], root};
        }
    }
}