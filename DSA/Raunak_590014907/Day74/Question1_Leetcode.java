import java.util.*;

class Solution {

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        long answer = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int size = dfs(i, graph, visited);

                // Nodes in this component cannot pair
                // with nodes in this component.
                answer += (long) size * (remaining - size);

                remaining -= size;
            }
        }

        return answer;
    }

    private int dfs(int node,
                    List<List<Integer>> graph,
                    boolean[] visited) {

        visited[node] = true;

        int size = 1;

        for (int neighbor : graph.get(node)) {

            if (!visited[neighbor]) {
                size += dfs(neighbor, graph, visited);
            }
        }

        return size;
    }
}