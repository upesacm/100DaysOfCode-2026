
import java.util.*;
class RSC{
    static class Edge {
        int to, cost;
        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    public static int minCost(int n, int[][] roads) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0] - 1;
            int v = road[1] - 1;
            int cost = road[2];
            graph.get(u).add(new Edge(v, 0));
            graph.get(v).add(new Edge(u, cost));
        }
        int ans = Integer.MAX_VALUE;
        for (int start = 0; start < n; start++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[start] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[1])
            );

            pq.offer(new int[]{start, 0});
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int u = cur[0];
                int d = cur[1];
                if (d != dist[u])
                    continue;
                for (Edge e : graph.get(u)) {
                    if (dist[e.to] > d + e.cost) {
                        dist[e.to] = d + e.cost;
                        pq.offer(new int[]{e.to, dist[e.to]});
                    }
                }
            }

            int max = 0;
            for (int d : dist) {
                if (d == Integer.MAX_VALUE)
                    return -1;
                max = Math.max(max, d);
            }

            ans = Math.min(ans, max);
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] roads = {{1, 3, 1},{1, 2, 1}, {3, 2, 1}};
        System.out.println(minCost(n, roads));
    }
}