import java.io.*;
import java.util.*;

public class Question2 {

    static class Edge {
        int to;
        int reverse;
        int capacity;

        Edge(int to, int reverse, int capacity) {
            this.to = to;
            this.reverse = reverse;
            this.capacity = capacity;
        }
    }

    static class Dinic {

        ArrayList<Edge>[] graph;
        int[] level;
        int[] pointer;

        @SuppressWarnings("unchecked")
        Dinic(int n) {
            graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            level = new int[n];
            pointer = new int[n];
        }

        void addEdge(int from, int to, int capacity) {

            Edge forward = new Edge(
                to,
                graph[to].size(),
                capacity
            );

            Edge backward = new Edge(
                from,
                graph[from].size(),
                0
            );

            graph[from].add(forward);
            graph[to].add(backward);
        }

        boolean bfs(int source, int sink) {

            Arrays.fill(level, -1);

            Queue<Integer> queue = new ArrayDeque<>();

            queue.offer(source);
            level[source] = 0;

            while (!queue.isEmpty()) {

                int current = queue.poll();

                for (Edge edge : graph[current]) {

                    if (edge.capacity > 0 &&
                        level[edge.to] == -1) {

                        level[edge.to] = level[current] + 1;
                        queue.offer(edge.to);
                    }
                }
            }

            return level[sink] != -1;
        }

        int dfs(int current, int sink, int flow) {

            if (current == sink) {
                return flow;
            }

            while (pointer[current] < graph[current].size()) {

                Edge edge =
                    graph[current].get(pointer[current]);

                if (edge.capacity > 0 &&
                    level[edge.to] == level[current] + 1) {

                    int pushed = dfs(
                        edge.to,
                        sink,
                        Math.min(flow, edge.capacity)
                    );

                    if (pushed > 0) {

                        edge.capacity -= pushed;

                        graph[edge.to]
                            .get(edge.reverse)
                            .capacity += pushed;

                        return pushed;
                    }
                }

                pointer[current]++;
            }

            return 0;
        }

        int maxFlow(int source, int sink) {

            int totalFlow = 0;

            while (bfs(source, sink)) {

                Arrays.fill(pointer, 0);

                int pushed;

                while ((pushed = dfs(
                    source,
                    sink,
                    Integer.MAX_VALUE
                )) > 0) {

                    totalFlow += pushed;
                }
            }

            return totalFlow;
        }
    }


    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int testCases = fs.nextInt();

        StringBuilder answer = new StringBuilder();

        while (testCases-- > 0) {

            int n = fs.nextInt();
            int T = fs.nextInt();
            int m = fs.nextInt();

            int source = 0;
            int headStart = 1;
            int footStart = n + 1;
            int sink = 2 * n + 1;

            Dinic dinic = new Dinic(2 * n + 2);

            for (int i = 0; i < n; i++) {
                dinic.addEdge(
                    source,
                    headStart + i,
                    T
                );
            }

            for (int i = 0; i < n; i++) {
                dinic.addEdge(
                    footStart + i,
                    sink,
                    1
                );
            }

            for (int i = 0; i < m; i++) {

                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;

                dinic.addEdge(
                    headStart + u,
                    footStart + v,
                    1
                );

                dinic.addEdge(
                    headStart + v,
                    footStart + u,
                    1
                );
            }

            int result = dinic.maxFlow(source, sink);

            answer.append(result).append('\n');
        }

        System.out.print(answer);
    }


    static class FastScanner {

        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];

        private int pointer = 0;
        private int length = 0;

        private int read() throws IOException {

            if (pointer >= length) {

                length = in.read(buffer);
                pointer = 0;

                if (length <= 0) {
                    return -1;
                }
            }

            return buffer[pointer++];
        }

        int nextInt() throws IOException {

            int c;

            do {
                c = read();
            } while (c <= ' ' && c != -1);

            int number = 0;

            while (c > ' ') {

                number = number * 10 + (c - '0');
                c = read();
            }

            return number;
        }
    }
}