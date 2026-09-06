class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        long unreachablePairs = 0;
        long nodesVisitedSoFar = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long componentSize = dfs(i, adj, visited);
                unreachablePairs += componentSize * nodesVisitedSoFar;
                nodesVisitedSoFar += componentSize;
            }
        }
        return unreachablePairs;
    }

    private long dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        long size = 1;
        
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, adj, visited);
            }
        }
        return size;
    }
}