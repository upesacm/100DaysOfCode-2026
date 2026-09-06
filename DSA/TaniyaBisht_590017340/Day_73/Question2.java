
import java.util.*;
class DA{
    static void dfs(int node, ArrayList<Integer>[] graph,
                    boolean[] visited, int[] size) {
        visited[node] = true;
        size[0]++;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, size);
            }
        }
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] edges = { {1, 2}, {2, 3}, {1, 4}};
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[N + 1];
        int clusters = 0;
        int largestCluster = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                clusters++;
                int[] size = {0};
                dfs(i, graph, visited, size);
                largestCluster = Math.max(largestCluster, size[0]);
            }
        }
        System.out.println("Number of wells:" + clusters);
        System.out.println("Largest cluster:" + largestCluster);
    }
}