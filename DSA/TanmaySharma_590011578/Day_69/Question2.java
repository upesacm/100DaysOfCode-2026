import java.util.*;

public class Question2 {
    static class Node {
        int val;
        Node left, right;
        Node(int val) {
            this.val = val;
        }
    }

    public static List<String> splitBST(int[] tree, int K) {
        Node root = buildTree(tree);
        Node[] parts = split(root, K);
        List<String> result = new ArrayList<>();
        result.add(preorder(parts[0]));
        result.add(preorder(parts[1]));
        return result;
    }

    private static Node buildTree(int[] nums) {
        Node root = null;
        for (int num : nums) {
            root = insert(root, num);
        }
        return root;
    }

    private static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    private static Node[] split(Node root, int K) {
        if (root == null) return new Node[]{null, null};
        Node[] parts;
        if (root.val < K) {
            parts = split(root.right, K);
            root.right = parts[0];
            parts[0] = root;
        } else {
            parts = split(root.left, K);
            root.left = parts[1];
            parts[1] = root;
        }
        return parts;
    }

    private static String preorder(Node root) {
        if (root == null) return "EMPTY";
        StringBuilder sb = new StringBuilder();
        preorderHelper(root, sb);
        return sb.toString().trim();
    }

    private static void preorderHelper(Node root, StringBuilder sb) {
        if (root == null) return;
        if (sb.length() > 0) sb.append(' ');
        sb.append(root.val);
        preorderHelper(root.left, sb);
        preorderHelper(root.right, sb);
    }
}