import java.util.*;

class Solution {

    public long countPairs(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        long remaining = n;
        long answer = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                long size = dfs(i, graph, visited);

                remaining -= size;

                answer += size * remaining;
            }
        }

        return answer;
    }

    private long dfs(int node, List<List<Integer>> graph, boolean[] visited) {

        visited[node] = true;

        long count = 1;

        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {
                count += dfs(neighbour, graph, visited);
            }
        }

        return count;
    }
}
