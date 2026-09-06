import java.io.*;
import java.util.*;

public class CrabChaos {

    static int[][] capacity;
    static int[][] flow;
    static int V;

    // BFS to find an augmenting path
    static boolean bfs(int source, int sink, int[] parent) {

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v = 0; v < V; v++) {

                // Residual capacity
                if (!visited[v] &&
                    capacity[u][v] - flow[u][v] > 0) {

                    parent[v] = u;
                    visited[v] = true;
                    queue.add(v);

                    if (v == sink) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Edmonds-Karp Maximum Flow
    static int maxFlow(int source, int sink) {

        int maxFlow = 0;
        int[] parent = new int[V];

        while (bfs(source, sink, parent)) {

            int pathFlow = Integer.MAX_VALUE;

            // Find minimum capacity on the path
            int v = sink;

            while (v != source) {

                int u = parent[v];

                pathFlow = Math.min(
                    pathFlow,
                    capacity[u][v] - flow[u][v]
                );

                v = u;
            }

            // Update flow along the path
            v = sink;

            while (v != source) {

                int u = parent[v];

                flow[u][v] += pathFlow;
                flow[v][u] -= pathFlow;

                v = u;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    static int crabGraphs(int n, int t, int[][] edges) {

        /*
         * Nodes:
         *
         * 0              = source
         *
         * 1 ... n        = HEAD copies
         *
         * n+1 ... 2n     = FOOT copies
         *
         * 2n + 1         = sink
         */

        int source = 0;
        int sink = 2 * n + 1;

        V = 2 * n + 2;

        capacity = new int[V][V];
        flow = new int[V][V];

        // Add source -> head edges
        for (int i = 1; i <= n; i++) {

            // A head can have at most T feet
            capacity[source][i] = t;
        }

        // Add foot -> sink edges
        for (int i = 1; i <= n; i++) {

            int footNode = n + i;

            // A vertex can be used as a foot only once
            capacity[footNode][sink] = 1;
        }

        // Add graph edges:
        //
        // If u-v exists:
        // head(u) -> foot(v)
        // head(v) -> foot(u)

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int headU = u;
            int headV = v;

            int footU = n + u;
            int footV = n + v;

            capacity[headU][footV] = 1;
            capacity[headV][footU] = 1;
        }

        return maxFlow(source, sink);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (C-- > 0) {

            StringTokenizer st;

            // Read N, T, M
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] edges = new int[M][2];

            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine());

                edges[i][0] =
                    Integer.parseInt(st.nextToken());

                edges[i][1] =
                    Integer.parseInt(st.nextToken());
            }

            int answer = crabGraphs(N, T, edges);

            output.append(answer).append('\n');
        }

        System.out.print(output);
    }
}
