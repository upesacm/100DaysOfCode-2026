class Question1_leetcode {

    // DFS to find the size of a connected component
    int dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        // Mark the current node as visited
        visited[node] = true;

        // Count the current node
        int count = 1;

        // Visit all connected nodes
        for (int neighbour : graph.get(node)) {

            // If the node is not visited
            if (!visited[neighbour]) {

                // Add its component size
                count += dfs(neighbour, graph, visited);
            }
        }

        // Return total nodes in this component
        return count;
    }

    public long countPairs(int n, int[][] edges) {

        // Create an adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        // Create a list for every node
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add all edges to the graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // Undirected graph:
            // u is connected to v
            graph.get(u).add(v);

            // v is also connected to u
            graph.get(v).add(u);
        }

        // Keep track of visited nodes
        boolean[] visited = new boolean[n];

        // Final answer
        long answer = 0;

        // Number of nodes in previous components
        long previousNodes = 0;

        // Find every connected component
        for (int i = 0; i < n; i++) {

            // If this node is not visited,
            // start a new component
            if (!visited[i]) {

                // Find the size of this component
                int componentSize = dfs(i, graph, visited);

                /*
                 * Every node in this component is unreachable
                 * from every node in previous components.
                 *
                 * Number of pairs:
                 *
                 * componentSize * previousNodes
                 */
                answer += (long) componentSize * previousNodes;

                // Add current component's nodes
                // to previous nodes
                previousNodes += componentSize;
            }
        }

        // Return the answer
        return answer;
    }
}