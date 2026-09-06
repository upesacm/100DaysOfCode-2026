public class Question2 {
    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public static int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) insert(root, num);
        int max = 0;
        for (int num : nums) max = Math.max(max, getMaxXOR(root, num));
        return max;
    }

    static void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.child[bit] == null) node.child[bit] = new TrieNode();
            node = node.child[bit];
        }
    }

    static int getMaxXOR(TrieNode root, int num) {
        TrieNode node = root;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.child[opposite] != null) {
                result |= (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(findMaximumXOR(nums));
    }
}