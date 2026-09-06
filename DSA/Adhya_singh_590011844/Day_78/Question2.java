import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    static void insert(int num) {
        TrieNode node = root;

        for (int bit = 30; bit >= 0; bit--) {

            int b = (num >> bit) & 1;

            if (node.child[b] == null) {
                node.child[b] = new TrieNode();
            }

            node = node.child[b];
        }
    }

    static int getMaxXor(int num) {
        TrieNode node = root;
        int result = 0;

        for (int bit = 30; bit >= 0; bit--) {

            int b = (num >> bit) & 1;
            int opposite = b ^ 1;
            if (node.child[opposite] != null) {
                result |= (1 << bit);
                node = node.child[opposite];
            } else {
                node = node.child[b];
            }
        }

        return result;
    }

    static int maximumXor(int[] arr) {

        insert(arr[0]);

        int maxXor = 0;

        for (int i = 1; i < arr.length; i++) {

            maxXor = Math.max(maxXor, getMaxXor(arr[i]));

            insert(arr[i]);
        }

        return maxXor;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = fs.nextInt();
        }

        System.out.println(maximumXor(arr));
    }

    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int ptr = 0;
        private int len = 0;

        private int read() throws IOException {

            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len == -1) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result * sign;
        }
    }
}