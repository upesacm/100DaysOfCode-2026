import java.io.*;
import java.util.*;

public class Main {

    static int largestPathValue(
            String colors,
            int[][] edges) {

        int n = colors.length;

        int[][] graph = new int[n][];
        int[] indegree = new int[n];
        int[] degree = new int[n];

        for (int[] edge : edges) {
            degree[edge[0]]++;
            indegree[edge[1]]++;
        }

        for (int i = 0; i < n; i++) {
            graph[i] = new int[degree[i]];
        }

        int[] ptr = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u][ptr[u]++] = v;
        }

        int[][] dp = new int[n][26];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;
        int answer = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();
            processed++;

            int currentColor =
                    colors.charAt(u) - 'a';

            dp[u][currentColor]++;

            answer = Math.max(
                    answer,
                    dp[u][currentColor]
            );

            for (int v : graph[u]) {

                for (int c = 0; c < 26; c++) {

                    dp[v][c] = Math.max(
                            dp[v][c],
                            dp[u][c]
                    );
                }

                indegree[v]--;

                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        if (processed != n) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args)
            throws Exception {

        FastScanner fs =
                new FastScanner(System.in);

        String colors = fs.next();
        int n = colors.length();

        int m = fs.nextInt();

        int[][] edges = new int[m][2];

        for (int i = 0; i < m; i++) {
            edges[i][0] = fs.nextInt();
            edges[i][1] = fs.nextInt();
        }

        System.out.println(
                largestPathValue(colors, edges)
        );
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer =
                new byte[1 << 16];

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

        String next() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ');

            StringBuilder sb =
                    new StringBuilder();

            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }

            return sb.toString();
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
                result =
                        result * 10 + c - '0';
                c = read();
            }

            return result * sign;
        }
    }
}