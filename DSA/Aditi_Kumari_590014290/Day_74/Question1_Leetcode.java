package Day_74;
import java.util.*;
class Solution {
    public long countPairs(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long ans = 0;
        long previous = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long size = dfs(i, graph, visited);
                ans += size * previous;
                previous += size;
            }
        }

        return ans;
    }
    private long dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        long size = 1;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                size += dfs(next, graph, visited);
            }
        }
        return size;
    }
}