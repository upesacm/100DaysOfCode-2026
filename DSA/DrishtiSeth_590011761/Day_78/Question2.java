import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    // Insert a number into the binary trie
    static void insert(int num) {
        TrieNode node = root;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            if (node.child[bit] == null) {
                node.child[bit] = new TrieNode();
            }

            node = node.child[bit];
        }
    }

    // Find maximum XOR possible with num
    static int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;

            // We want the opposite bit to maximize XOR
            int opposite = 1 - bit;

            if (node.child[opposite] != null) {
                maxXor = maxXor | (1 << i);
                node = node.child[opposite];
            } else {
                node = node.child[bit];
            }
        }

        return maxXor;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Insert all numbers
        for (int num : arr) {
            insert(num);
        }

        int answer = 0;

        // Find maximum XOR
        for (int num : arr) {
            answer = Math.max(answer, findMaxXor(num));
        }

        System.out.println(answer);

        sc.close();
    }
}
