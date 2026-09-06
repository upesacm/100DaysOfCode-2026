class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    public int findMaximumXOR(int[] nums) {

        TrieNode root = new TrieNode();


        for (int num : nums) {
            insert(root, num);
        }

        int max = 0;


        for (int num : nums) {
            max = Math.max(max, getMaxXOR(root, num));
        }

        return max;
    }
    public void insert(TrieNode root, int num) {

        TrieNode curr = root;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }

            curr = curr.child[bit];
        }
    }

    public int getMaxXOR(TrieNode root, int num) {

        TrieNode curr = root;
        int result = 0;

        for (int i = 31; i >= 0; i--) {

            int bit = (num >> i) & 1;

            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                result = result | (1 << i);
                curr = curr.child[opposite];
            } 
            else {
                curr = curr.child[bit];
            }
        }

        return result;
    }
}