class Solution {
    public long countPairs(int n, int[][] edges) {
         List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        long ans = 0;
        long remaining = n;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long size = dfs(i, graph, visited);

                // Pairs between this component and all remaining nodes
                ans += size * (remaining - size);

                remaining -= size;
            }
        }

        return ans;
    }

    private long dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        long count = 1;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited);
            }
        }

        return count;
        
    }
}
