import java.io.*;
import java.util.*;

public class Solution {

    static class Edge {
        int to;
        int capacity;
        int flow;
        Edge reverse;

        Edge(int to, int capacity) {
            this.to = to;
            this.capacity = capacity;
            this.flow = 0;
        }
    }

    static class Dinic {

        int n;
        List<Edge>[] graph;
        int[] level;
        int[] ptr;

        Dinic(int n) {
            this.n = n;

            graph = new ArrayList[n];

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }

            level = new int[n];
            ptr = new int[n];
        }

        void addEdge(int u, int v, int capacity) {

            Edge forward = new Edge(v, capacity);
            Edge backward = new Edge(u, 0);

            forward.reverse = backward;
            backward.reverse = forward;

            graph[u].add(forward);
            graph[v].add(backward);
        }

        boolean bfs(int source, int sink) {

            Arrays.fill(level, -1);

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(source);
            level[source] = 0;

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (Edge edge : graph[node]) {

                    if (level[edge.to] == -1 &&
                        edge.flow < edge.capacity) {

                        level[edge.to] = level[node] + 1;
                        queue.offer(edge.to);
                    }
                }
            }

            return level[sink] != -1;
        }

        int dfs(int node, int sink, int pushed) {

            if (pushed == 0) {
                return 0;
            }

            if (node == sink) {
                return pushed;
            }

            for (; ptr[node] < graph[node].size(); ptr[node]++) {

                Edge edge = graph[node].get(ptr[node]);

                if (level[edge.to] == level[node] + 1 &&
                    edge.flow < edge.capacity) {

                    int possibleFlow =
                            Math.min(pushed, edge.capacity - edge.flow);

                    int flow =
                            dfs(edge.to, sink, possibleFlow);

                    if (flow > 0) {

                        edge.flow += flow;
                        edge.reverse.flow -= flow;

                        return flow;
                    }
                }
            }

            return 0;
        }

        int maxFlow(int source, int sink) {

            int totalFlow = 0;

            while (bfs(source, sink)) {

                Arrays.fill(ptr, 0);

                while (true) {

                    int flow = dfs(source, sink, Integer.MAX_VALUE);

                    if (flow == 0) {
                        break;
                    }

                    totalFlow += flow;
                }
            }

            return totalFlow;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);

        int C = fs.nextInt();

        StringBuilder output = new StringBuilder();

        while (C-- > 0) {

            int N = fs.nextInt();
            int T = fs.nextInt();
            int M = fs.nextInt();

            /*
             * Nodes:
             *
             * 0 to N-1       -> Head nodes
             * N to 2N-1      -> Foot nodes
             *
             * Source = 2N
             * Sink   = 2N + 1
             */

            int source = 2 * N;
            int sink = 2 * N + 1;

            Dinic dinic = new Dinic(2 * N + 2);

            // Source -> Head
            for (int i = 0; i < N; i++) {
                dinic.addEdge(source, i, T);
            }

            // Foot -> Sink
            for (int i = 0; i < N; i++) {
                dinic.addEdge(N + i, sink, 1);
            }

            // Graph edges
            for (int i = 0; i < M; i++) {

                int u = fs.nextInt() - 1;
                int v = fs.nextInt() - 1;

                // u as head, v as foot
                dinic.addEdge(u, N + v, 1);

                // v as head, u as foot
                dinic.addEdge(v, N + u, 1);
            }

            int answer = dinic.maxFlow(source, sink);

            output.append(answer).append("\n");
        }

        System.out.print(output);
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
