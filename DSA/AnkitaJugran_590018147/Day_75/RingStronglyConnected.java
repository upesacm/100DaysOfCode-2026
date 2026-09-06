import java.io.*;
import java.util.*;

public class RingStronglyConnected {

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        // Undirected adjacency list.
        // Each entry stores the neighboring city and the original directed edge.
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // Original direction: a -> b
            Edge edge = new Edge(a, b, c);

            graph[a].add(edge);
            graph[b].add(edge);
        }

        /*
         * Reconstruct the ring order.
         *
         * Start from city 1.
         * Pick one of its neighbors as the next city.
         */
        int[] order = new int[n];
        order[0] = 1;

        int prev = -1;
        int current = 1;

        for (int i = 1; i < n; i++) {
            int next = -1;

            for (Edge e : graph[current]) {
                int neighbor = (e.from == current) ? e.to : e.from;

                if (neighbor != prev) {
                    next = neighbor;
                    break;
                }
            }

            order[i] = next;
            prev = current;
            current = next;
        }

        /*
         * Calculate cost for the direction:
         *
         * order[0] -> order[1] -> ... -> order[n-1] -> order[0]
         */
        long cost1 = 0;

        for (int i = 0; i < n; i++) {
            int a = order[i];
            int b = order[(i + 1) % n];

            // Find the original directed edge between a and b.
            for (Edge e : graph[a]) {
                if ((e.from == a && e.to == b) ||
                    (e.from == b && e.to == a)) {

                    // If original direction is b -> a,
                    // we need to reverse it.
                    if (e.from != a) {
                        cost1 += e.cost;
                    }

                    break;
                }
            }
        }

        /*
         * The opposite direction requires reversing exactly
         * the edges that were NOT reversed in the first direction.
         */
        long totalCost = 0;

        for (int i = 0; i < n; i++) {
            int a = order[i];
            int b = order[(i + 1) % n];

            for (Edge e : graph[a]) {
                if ((e.from == a && e.to == b) ||
                    (e.from == b && e.to == a)) {

                    totalCost += e.cost;
                    break;
                }
            }
        }

        long cost2 = totalCost - cost1;

        System.out.println(Math.min(cost1, cost2));
    }
}
