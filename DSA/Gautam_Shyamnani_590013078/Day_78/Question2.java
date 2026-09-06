import java.io.*;
import java.util.*;

public class Question2 {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    static void insert(int num) {
        TrieNode current = root;

        for (int bit = 30; bit >= 0; bit--) {
            int currentBit = (num >> bit) & 1;

            if (current.child[currentBit] == null) {
                current.child[currentBit] = new TrieNode();
            }

            current = current.child[currentBit];
        }
    }

    static int findMaxXor(int num) {
        TrieNode current = root;
        int maxXor = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int currentBit = (num >> bit) & 1;

            int oppositeBit = 1 - currentBit;

            if (current.child[oppositeBit] != null) {
                maxXor |= (1 << bit);
                current = current.child[oppositeBit];
            } else {
                current = current.child[currentBit];
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
            insert(arr[i]);
        }

        int answer = 0;

        for (int num : arr) {
            answer = Math.max(answer, findMaxXor(num));
        }

        System.out.println(answer);
    }
}