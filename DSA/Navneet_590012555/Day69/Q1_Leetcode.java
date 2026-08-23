class Solution {
    int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    TreeNode build(int[] a, int min, int max) {
        if (i == a.length || a[i] < min || a[i] > max)
            return null;

        TreeNode root = new TreeNode(a[i]);
        i++;

        root.left = build(a, min, root.val);
        root.right = build(a, root.val, max);

        return root;
    }
}