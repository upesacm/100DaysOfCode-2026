import java.util.*;

public class Maximum_XOR {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    // Insert number into Trie
    static void insert(int num) {
        TrieNode curr = root;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;

            if (curr.child[b] == null) {
                curr.child[b] = new TrieNode();
            }

            curr = curr.child[b];
        }
    }

    // Find maximum XOR possible with num
    static int findMaxXOR(int num) {
        TrieNode curr = root;
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {

            int b = (num >> bit) & 1;

            // We want the opposite bit
            int opposite = 1 - b;

            if (curr.child[opposite] != null) {
                result = result | (1 << bit);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[b];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        // Read array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Insert all numbers into Trie
        for (int num : arr) {
            insert(num);
        }

        int answer = 0;

        // Find maximum XOR
        for (int num : arr) {
            answer = Math.max(answer, findMaxXOR(num));
        }

        System.out.println(answer);

        sc.close();
    }
}
