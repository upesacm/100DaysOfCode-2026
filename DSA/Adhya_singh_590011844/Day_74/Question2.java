import java.io.*;
import java.util.*;

public class Main {

    static int N, T;
    static ArrayList<Integer>[] graph;
    static boolean[] used;

    static int solve() {

        used = new boolean[N];

        Integer[] vertices = new Integer[N];

        for (int i = 0; i < N; i++) {
            vertices[i] = i;
        }

        Arrays.sort(vertices, (a, b) ->
                Integer.compare(graph[b].size(),
                                graph[a].size()));

        int answer = 0;

        for (int head : vertices) {

            if (used[head]) {
                continue;
            }

            int feet = 0;

            for (int v : graph[head]) {

                if (!used[v] && v != head) {

                    used[v] = true;
                    feet++;

                    if (feet == T) {
                        break;
                    }
                }
            }

            if (feet > 0) {

                used[head] = true;
                answer += 1 + feet;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int C = fs.nextInt();

        StringBuilder out = new StringBuilder();

        while (C-- > 0) {

            N = fs.nextInt();
            T = fs.nextInt();
            int M = fs.nextInt();

            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] g =
                    new ArrayList[N];

            graph = g;

            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {

                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;

                graph[u].add(v);
                graph[v].add(u);
            }

            out.append(solve()).append('\n');
        }

        System.out.print(out);
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

            int value = 0;

            while (c > ' ') {
                value = value * 10 + (c - '0');
                c = read();
            }

            return value * sign;
        }
    }
}