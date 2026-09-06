class Solution {

    static class Node {
        Node[] child = new Node[2];
    }

    Node root = new Node();


    public void insert(int num) {
        Node curr = root;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new Node();
            }

            curr = curr.child[bit];
        }
    }


    public int findMaxXor(int num) {
        Node curr = root;
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;

            // Try to find opposite bit
            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                result = result | (1 << i);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[bit];
            }
        }

        return result;
    }

    public int maximumXOR(int[] nums) {

   
        for (int num : nums) {
            insert(num);
        }

        int max = 0;

   
        for (int num : nums) {
            int currentXor = findMaxXor(num);
            max = Math.max(max, currentXor);
        }

        return max;
    }
}
