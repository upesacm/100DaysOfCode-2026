import java.util.*;

class Solution {

    public static void solve(int n, int m, int[][] edges, int s) {

        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Store main roads
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // Nodes which have not been visited yet
        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            if (i != s) {
                unvisited.add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        dist[s] = 0;
        queue.offer(s);

        while (!queue.isEmpty()) {

            int u = queue.poll();

            List<Integer> toRemove = new ArrayList<>();

            for (int v : unvisited) {

                // If there is NO main road,
                // then there is a village road.
                if (!hasEdge(graph[u], v)) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                    toRemove.add(v);
                }
            }

            // Remove all newly visited nodes
            for (int v : toRemove) {
                unvisited.remove(v);
            }
        }

        // Print distances excluding S
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                System.out.print(dist[i] + " ");
            }
        }

        System.out.println();
    }

    private static boolean hasEdge(List<Integer> list, int target) {
        return list.contains(target);
    }
}
