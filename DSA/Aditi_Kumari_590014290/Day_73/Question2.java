package Day_73;

import java.util.*;
public class Question2 {
    static int dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int size = 1;

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                size += dfs(next, graph, visited);
            }
        }

        return size;
    }
    static void solve(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n + 1];
        int clusters = 0;
        int largestCluster = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                clusters++;
                int size = dfs(i, graph, visited);
                largestCluster = Math.max(largestCluster, size);
            }
        }
        System.out.println(clusters + " " + largestCluster);
    }
}

