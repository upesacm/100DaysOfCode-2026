import java.io.*;
import java.util.*;

public class Main {

    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];
    }

    static long countPairs(int n, int[][] edges) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        long answer = 0;
        long nodesSeen = 0;

        for (int i = 0; i < n; i++) {

            if (find(i) == i) {

                long componentSize = size[i];

                answer += componentSize * nodesSeen;

                nodesSeen += componentSize;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int m = fs.nextInt();

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            edges[i][0] = fs.nextInt();
            edges[i][1] = fs.nextInt();
        }

        System.out.println(countPairs(n, edges));
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

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