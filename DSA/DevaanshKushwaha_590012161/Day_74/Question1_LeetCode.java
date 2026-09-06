import java.util.*;

public class Main {

    static void dfs(int node, List<Integer>[] graph, boolean[] visited, int[] count) {
        visited[node] = true;
        count[0]++;

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, count);
            }
        }
    }

    public static long countUnreachablePairs(int n, int[][] edges) {

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

        long answer = 0;
        long processed = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                int[] count = {0};
                dfs(i, graph, visited, count);

                long size = count[0];

                answer += size * (n - processed - size);

                processed += size;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int n = 7;

        int[][] edges = {
            {0, 2},
            {0, 5},
            {2, 4},
            {1, 6},
            {5, 4}
        };

        System.out.println(countUnreachablePairs(n, edges));
    }
}
