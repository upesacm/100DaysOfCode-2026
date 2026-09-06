import java.util.*;

class Solution {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    static void insert(int num) {
        TrieNode curr = root;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (curr.child[bit] == null) {
                curr.child[bit] = new TrieNode();
            }

            curr = curr.child[bit];
        }
    }

    static int getMaxXOR(int num) {
        TrieNode curr = root;
        int xor = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                xor |= (1 << i);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[bit];
            }
        }

        return xor;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        for (int num : arr) {
            insert(num);
        }

        int answer = 0;

        for (int num : arr) {
            answer = Math.max(answer, getMaxXOR(num));
        }

        System.out.println(answer);
    }
}