import java.util.*;

public class Main {

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

    static int getMaxXor(int num) {
        TrieNode curr = root;
        int result = 0;

        for (int i = 30; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;

            if (curr.child[opposite] != null) {
                result |= (1 << i);
                curr = curr.child[opposite];
            } else {
                curr = curr.child[bit];
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

        int answer = 0;

        // Insert the first element
        insert(arr[0]);

        for (int i = 1; i < n; i++) {
            answer = Math.max(answer, getMaxXor(arr[i]));
            insert(arr[i]);
        }

        System.out.println(answer);
    }
}
