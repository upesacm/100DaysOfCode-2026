class Solution {
    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        long ans = 0;
        long previous = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            long size = dfs(i, graph, visited);

            ans += size * previous;
            previous += size;
        }

        return ans;
    }

    private long dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        long size = 1;

        for (int next : graph[node]) {
            if (!visited[next]) {
                size += dfs(next, graph, visited);
            }
        }

        return size;
    }
}
