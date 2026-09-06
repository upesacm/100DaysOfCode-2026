import java.util.*;

class Solution {
    public long countPairs(int n, int[][] edges) {
        // Build adjacency list
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n];
        long remaining = n;
        long ans = 0;

        // Find each connected component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {

                long size = 0;

                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    size++;

                    for (int neighbor : graph[node]) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.add(neighbor);
                        }
                    }
                }

                // Nodes in this component cannot pair
                // with nodes in remaining components
                remaining -= size;
                ans += size * remaining;
            }
        }

        return ans;
    }
}