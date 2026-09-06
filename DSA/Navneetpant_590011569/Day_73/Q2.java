import java.util.*;

class Solution {

    public static int[] shortestDistance(int n, int[][] edges, int s) {

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

        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        dist[s] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);

        TreeSet<Integer> unvisited = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (i != s) {
                unvisited.add(i);
            }
        }

        while (!queue.isEmpty()) {

            int u = queue.poll();

            HashSet<Integer> mainRoads = new HashSet<>(graph[u]);

            List<Integer> toVisit = new ArrayList<>();

            for (int v : unvisited) {
                if (!mainRoads.contains(v)) {
                    toVisit.add(v);
                }
            }

            for (int v : toVisit) {
                dist[v] = dist[u] + 1;
                queue.offer(v);
                unvisited.remove(v);
            }
        }

        return dist;
    }
}