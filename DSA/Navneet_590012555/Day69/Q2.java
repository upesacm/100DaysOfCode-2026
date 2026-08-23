class Solution {
    public String[] splitBST(TreeNode root, int k) {
        TreeNode[] x = split(root, k);

        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();

        preorder(x[0], a);
        preorder(x[1], b);

        return new String[] {
                a.length() == 0 ? "EMPTY" : a.toString().trim(),
                b.length() == 0 ? "EMPTY" : b.toString().trim()
        };
    }

    TreeNode[] split(TreeNode root, int k) {
        if (root == null)
            return new TreeNode[] { null, null };

        if (root.val < k) {
            TreeNode[] x = split(root.right, k);

            root.right = x[0];

            return new TreeNode[] { root, x[1] };
        } else {
            TreeNode[] x = split(root.left, k);

            root.left = x[1];

            return new TreeNode[] { x[0], root };
        }
    }

    void preorder(TreeNode root, StringBuilder s) {
        if (root == null)
            return;

        s.append(root.val).append(" ");
        preorder(root.left, s);
        preorder(root.right, s);
    }
}