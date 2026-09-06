import java.util.*;

public class EulerTrail {

    /*
     * A graph has an Euler trail if:
     *
     * 1. All vertices with non-zero degree belong to one connected component.
     * 2. Number of vertices with odd degree is either:
     *      - 0  -> Euler circuit
     *      - 2  -> Euler path
     */

    static class Edge {
        int u, v;

        Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    /*
     * Check whether a graph has an Euler trail.
     */
    static boolean hasEulerTrail(int n, List<Edge> edges) {

        if (edges.isEmpty()) {
            return true;
        }

        int[] degree = new int[n];

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (Edge e : edges) {
            degree[e.u]++;
            degree[e.v]++;

            graph[e.u].add(e.v);
            graph[e.v].add(e.u);
        }

        // Count vertices with odd degree
        int odd = 0;

        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 != 0) {
                odd++;
            }
        }

        // Euler trail requires 0 or 2 odd-degree vertices
        if (odd != 0 && odd != 2) {
            return false;
        }

        // Find a vertex having at least one edge
        int start = -1;

        for (int i = 0; i < n; i++) {
            if (degree[i] > 0) {
                start = i;
                break;
            }
        }

        // Check connectivity
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        // Every vertex with an edge must be reachable
        for (int i = 0; i < n; i++) {
            if (degree[i] > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    /*
     * Construct the line graph.
     *
     * Original graph:
     *
     *       A
     *       |
     *       B --- C
     *
     * Each EDGE becomes a VERTEX in the line graph.
     *
     * Two vertices in the line graph are connected
     * if their corresponding original edges share a vertex.
     */
    static List<Edge> buildLineGraph(int n, List<Edge> edges) {

        int m = edges.size();

        // The line graph has m vertices.
        List<Edge> newEdges = new ArrayList<>();

        // Compare every pair of original edges.
        for (int i = 0; i < m; i++) {

            for (int j = i + 1; j < m; j++) {

                Edge e1 = edges.get(i);
                Edge e2 = edges.get(j);

                // If the two original edges share a vertex,
                // connect their corresponding vertices.
                if (e1.u == e2.u ||
                    e1.u == e2.v ||
                    e1.v == e2.u ||
                    e1.v == e2.v) {

                    newEdges.add(new Edge(i, j));
                }
            }
        }

        return newEdges;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        /*
         * Input format:
         *
         * n m k
         *
         * followed by m lines:
         *
         * u v
         */

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            edges.add(new Edge(u, v));
        }

        /*
         * Apply line graph transformation k times.
         */
        int vertices = n;

        for (int i = 0; i < k; i++) {

            edges = buildLineGraph(vertices, edges);

            // Number of vertices in a line graph
            // equals the number of edges in the old graph.
            vertices = m;

            m = edges.size();
        }

        boolean answer = hasEulerTrail(vertices, edges);

        System.out.println(answer);
    }
}