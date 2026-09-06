import java.util.*;

public class Question2 {

    /*
     * ============================================================
     * IDEA
     * ============================================================
     *
     * A LINE GRAPH is made like this:
     *
     * - Every EDGE of the original graph becomes a VERTEX.
     * - Two new vertices are connected if their original edges
     *   shared a common vertex.
     *
     * We repeat this process K times.
     *
     * After getting the K-th line graph, we check whether it
     * has an Euler Trail.
     *
     * ============================================================
     * EULER TRAIL CONDITIONS
     * ============================================================
     *
     * An undirected graph has an Euler Trail if:
     *
     * 1. All vertices having edges belong to one connected
     *    component.
     *
     * 2. The number of vertices having ODD degree is either:
     *
     *       0  -> Euler Circuit
     *       2  -> Euler Trail
     *
     * If the number of odd-degree vertices is anything else,
     * there is no Euler Trail.
     *
     * ============================================================
     */


    /*
     * This function creates the LINE GRAPH of the given graph.
     *
     * Example:
     *
     * Original graph:
     *
     *       1
     *      / \
     *     2---3
     *
     * Suppose the edges are:
     *
     * e0 = (1,2)
     * e1 = (1,3)
     * e2 = (2,3)
     *
     * In the line graph, e0, e1 and e2 become vertices.
     *
     * Since every pair of original edges shares a vertex,
     * the line graph becomes a triangle.
     */
    static List<List<Integer>> createLineGraph(
            List<List<Integer>> graph) {

        // Number of vertices in the current graph
        int n = graph.size();

        /*
         * We need a list of all edges.
         *
         * Every edge will become one vertex
         * in the new line graph.
         */
        ArrayList<int[]> edges = new ArrayList<>();

        // Find all edges
        for (int u = 0; u < n; u++) {

            for (int v : graph.get(u)) {

                /*
                 * Since the graph is undirected,
                 * (u,v) and (v,u) are the same edge.
                 *
                 * We only take u < v to store it once.
                 */
                if (u < v) {
                    edges.add(new int[]{u, v});
                }
            }
        }

        // Number of vertices in the new line graph
        int newN = edges.size();

        // Create the new graph
        List<List<Integer>> lineGraph = new ArrayList<>();

        // Create an empty list for every new vertex
        for (int i = 0; i < newN; i++) {
            lineGraph.add(new ArrayList<>());
        }

        /*
         * Compare every pair of edges.
         *
         * If two original edges share a vertex,
         * connect their corresponding vertices
         * in the line graph.
         */
        for (int i = 0; i < newN; i++) {

            // First edge
            int u1 = edges.get(i)[0];
            int v1 = edges.get(i)[1];

            for (int j = i + 1; j < newN; j++) {

                // Second edge
                int u2 = edges.get(j)[0];
                int v2 = edges.get(j)[1];

                /*
                 * Check whether the two edges share
                 * at least one endpoint.
                 */
                if (u1 == u2 ||
                    u1 == v2 ||
                    v1 == u2 ||
                    v1 == v2) {

                    // Connect i and j
                    lineGraph.get(i).add(j);
                    lineGraph.get(j).add(i);
                }
            }
        }

        // Return the newly created line graph
        return lineGraph;
    }


    /*
     * ============================================================
     * CHECK EULER TRAIL
     * ============================================================
     *
     * Returns true if the graph has an Euler Trail.
     */
    static boolean hasEulerTrail(List<List<Integer>> graph) {

        // Number of vertices
        int n = graph.size();

        /*
         * If there are no vertices, there is no useful
         * Euler Trail.
         */
        if (n == 0) {
            return false;
        }

        // Count vertices having odd degree
        int oddCount = 0;

        // Find a vertex that actually has an edge
        int start = -1;

        for (int i = 0; i < n; i++) {

            // If this vertex has at least one edge
            if (!graph.get(i).isEmpty()) {

                // Use it as the starting vertex for DFS
                if (start == -1) {
                    start = i;
                }

                // Check whether its degree is odd
                if (graph.get(i).size() % 2 == 1) {
                    oddCount++;
                }
            }
        }

        /*
         * Euler Trail is possible only when there are:
         *
         * 0 odd vertices
         * OR
         * 2 odd vertices
         */
        if (oddCount != 0 && oddCount != 2) {
            return false;
        }

        /*
         * If there are no edges, there is nothing to travel.
         * We consider this as a valid Euler Trail.
         */
        if (start == -1) {
            return true;
        }

        /*
         * Now check CONNECTIVITY.
         *
         * All vertices having edges must be connected.
         */
        boolean[] visited = new boolean[n];

        // Start DFS from a vertex having an edge
        dfs(start, graph, visited);

        // Check every vertex
        for (int i = 0; i < n; i++) {

            /*
             * If a vertex has an edge but was not visited,
             * then the graph is disconnected.
             */
            if (!graph.get(i).isEmpty() && !visited[i]) {
                return false;
            }
        }

        // Both conditions are satisfied
        return true;
    }


    /*
     * Simple DFS used to check connectivity.
     */
    static void dfs(
            int node,
            List<List<Integer>> graph,
            boolean[] visited) {

        // Mark current vertex as visited
        visited[node] = true;

        // Visit all neighbours
        for (int neighbour : graph.get(node)) {

            // If neighbour is not visited
            if (!visited[neighbour]) {

                // Visit it
                dfs(neighbour, graph, visited);
            }
        }
    }


    /*
     * ============================================================
     * MAIN
     * ============================================================
     */
    public static void main(String[] args) {

        // Scanner is used to take input
        Scanner sc = new Scanner(System.in);

        // Take number of vertices
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        // Take number of edges
        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        // Create the original graph
        List<List<Integer>> graph = new ArrayList<>();

        // Create an empty list for every vertex
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Take all edges
        System.out.println("Enter the edges:");

        for (int i = 0; i < m; i++) {

            // First endpoint
            int u = sc.nextInt();

            // Second endpoint
            int v = sc.nextInt();

            // Add the edge in both directions
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Take K
        System.out.print("Enter K: ");
        int k = sc.nextInt();

        /*
         * Create the line graph K times.
         *
         * If K = 1:
         *
         * Original graph
         *       ↓
         * First line graph
         *
         * If K = 2:
         *
         * Original graph
         *       ↓
         * First line graph
         *       ↓
         * Second line graph
         */
        for (int i = 0; i < k; i++) {

            // Convert current graph into its line graph
            graph = createLineGraph(graph);

            /*
             * If the line graph becomes empty,
             * we can stop.
             */
            if (graph.isEmpty()) {
                break;
            }
        }

        // Check whether the K-th line graph has an Euler Trail
        boolean answer = hasEulerTrail(graph);

        // Print the result
        System.out.println(answer);

        // Close Scanner
        sc.close();
    }
}


/*
================================================================
EXAMPLE
================================================================

Input:

4
4
0 1
1 2
2 3
3 0
1

The original graph is:

        0 -------- 1
        |          |
        |          |
        3 -------- 2


Every vertex has degree 2.

Therefore, the original graph has an Euler Circuit.

Now create its first line graph.

The 4 original edges become 4 new vertices.

The resulting line graph is also a cycle:

        e0 -------- e1
        |            |
        |            |
        e3 -------- e2


Every vertex has degree 2.

Number of odd-degree vertices = 0.

Therefore, it has an Euler Circuit.

Output:

true


================================================================
IMPORTANT
================================================================

Euler Trail:

    Number of odd-degree vertices = 0 or 2

Euler Circuit:

    Number of odd-degree vertices = 0


So the important part is:

if (oddCount == 0 || oddCount == 2)
    Euler Trail exists.


================================================================
TIME COMPLEXITY
================================================================

For each line graph:

We compare pairs of edges.

If there are E edges:

    O(E²)

We repeat this K times.

So the simple implementation is approximately:

    O(K * E²)

This version is intentionally written in a simple,
easy-to-understand way for learning.
*/
