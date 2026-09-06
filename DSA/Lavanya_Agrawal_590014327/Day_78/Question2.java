import java.util.*;

public class Question2 {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    static void insert(int num) {
        TrieNode current = root;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;

            if (current.child[b] == null) {
                current.child[b] = new TrieNode();
            }

            current = current.child[b];
        }
    }

    static int findMaxXOR(int num) {
        TrieNode current = root;
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            int opposite = 1 - b;

            if (current.child[opposite] != null) {
                result |= (1 << bit);
                current = current.child[opposite];
            } else {
                current = current.child[b];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Insert first element
        insert(arr[0]);

        int maxXor = 0;

        // Find maximum XOR with previously inserted elements
        for (int i = 1; i < n; i++) {
            maxXor = Math.max(maxXor, findMaxXOR(arr[i]));
            insert(arr[i]);
        }

        System.out.println(maxXor);

        sc.close();
    }
}