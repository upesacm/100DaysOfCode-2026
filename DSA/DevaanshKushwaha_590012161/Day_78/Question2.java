class Solution {

    // Each trie node has two children: bit 0 and bit 1
    class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private static final int BITS = 31; // enough for positive ints up to ~2^31 - 1

    private TrieNode root = new TrieNode();

    private void insert(int num) {
        TrieNode node = root;
        for (int i = BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Finds the max XOR achievable between num and any number already inserted
    private int queryMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = BITS; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int wantedBit = 1 - bit; // opposite bit maximizes XOR at this position
            if (node.children[wantedBit] != null) {
                maxXor |= (1 << i);
                node = node.children[wantedBit];
            } else {
                node = node.children[bit]; // fallback: only same-bit branch exists
            }
        }
        return maxXor;
    }

    public int findMaximumXOR(int[] nums) {
        int result = 0;
        insert(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            result = Math.max(result, queryMaxXor(nums[i]));
            insert(nums[i]);
        }
        return result;
    }
}
