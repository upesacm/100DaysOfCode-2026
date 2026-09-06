import java.util.*;

class Main {

    static class Edge {
        int to;
        int cost;
        boolean originalDirection;

        Edge(int to, int cost, boolean originalDirection) {
            this.to = to;
            this.cost = cost;
            this.originalDirection = originalDirection;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // Original direction: a -> b
            graph[a].add(new Edge(b, c, true));

            // Reverse direction for traversal
            graph[b].add(new Edge(a, c, false));
        }

        /*
         * Find the order of cities in the ring.
         */
        int[] order = new int[n];

        order[0] = 1;

        int previous = -1;
        int current = 1;

        for (int i = 1; i < n; i++) {

            int next = -1;

            for (Edge e : graph[current]) {
                if (e.to != previous) {
                    next = e.to;
                    break;
                }
            }

            order[i] = next;

            previous = current;
            current = next;
        }

        /*
         * Calculate cost for direction:
         * order[0] -> order[1] -> ... -> order[n-1] -> order[0]
         */
        int cost1 = 0;

        for (int i = 0; i < n; i++) {
            int u = order[i];
            int v = order[(i + 1) % n];

            // Find the road between u and v
            for (Edge e : graph[u]) {
                if (e.to == v) {

                    // If original direction is u -> v,
                    // no reversal required.
                    if (!e.originalDirection) {
                        cost1 += e.cost;
                    }

                    break;
                }
            }
        }

        /*
         * Opposite direction.
         *
         * Every edge that was correct for direction 1
         * now needs to be reversed.
         *
         * Therefore we can calculate the total cost
         * of all edges and subtract cost1.
         */
        int totalCost = 0;

        for (int i = 1; i <= n; i++) {
            for (Edge e : graph[i]) {
                if (e.originalDirection) {
                    totalCost += e.cost;
                }
            }
        }

        int cost2 = totalCost - cost1;

        System.out.println(Math.min(cost1, cost2));

        sc.close();
    }
}