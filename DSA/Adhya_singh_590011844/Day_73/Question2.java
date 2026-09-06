import java.io.*;
import java.util.*;

public class Main {

    static int[] shortestDistances(
            int n,
            ArrayList<Integer>[] graph,
            int start) {

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (i != start) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        dist[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {

            int u = queue.poll();

            HashSet<Integer> blocked = new HashSet<>(graph[u]);
            ArrayList<Integer> reached = new ArrayList<>();

            for (int v : unvisited) {
                if (!blocked.contains(v)) {
                    reached.add(v);
                }
            }

            for (int v : reached) {
                unvisited.remove(v);

                dist[v] = dist[u] + 1;
                queue.offer(v);
            }
        }

        return dist;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            int n = fs.nextInt();
            int m = fs.nextInt();

            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] graph =
                    new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {

                int u = fs.nextInt();
                int v = fs.nextInt();

                graph[u].add(v);
                graph[v].add(u);
            }

            int start = fs.nextInt();

            int[] dist =
                    shortestDistances(n, graph, start);

            boolean first = true;

            for (int i = 1; i <= n; i++) {

                if (i == start) {
                    continue;
                }

                if (!first) {
                    out.append(' ');
                }

                out.append(dist[i]);
                first = false;
            }

            out.append('\n');
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

                if (len <= 0) {
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