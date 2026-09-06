import java.util.*;

public class Question2 {

    static class Road {
        int to;
        int cost;
        boolean originalDirection;

        Road(int to, int cost, boolean originalDirection) {
            this.to = to;
            this.cost = cost;
            this.originalDirection = originalDirection;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<Road>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            // From a to b is the original direction
            graph[a].add(new Road(b, c, true));

            // From b to a means we would need to reverse it
            graph[b].add(new Road(a, c, false));
        }

        // Reconstruct the undirected ring
        int[] order = new int[n];

        boolean[] visited = new boolean[n + 1];

        int current = 1;

        for (int i = 0; i < n; i++) {

            order[i] = current;
            visited[current] = true;

            int next = -1;

            for (Road road : graph[current]) {
                if (!visited[road.to]) {
                    next = road.to;
                    break;
                }
            }

            if (next == -1) {
                break;
            }

            current = next;
        }

        int clockwiseCost = 0;

        // Make every edge follow order[i] -> order[i + 1]
        for (int i = 0; i < n; i++) {

            int u = order[i];
            int v = order[(i + 1) % n];

            for (Road road : graph[u]) {

                if (road.to == v) {

                    if (!road.originalDirection) {
                        clockwiseCost += road.cost;
                    }

                    break;
                }
            }
        }

        int totalCost = 0;

        for (int i = 1; i <= n; i++) {
            for (Road road : graph[i]) {
                if (road.originalDirection) {
                    totalCost += road.cost;
                }
            }
        }

        // Reverse direction of the whole ring
        int counterClockwiseCost = totalCost - clockwiseCost;

        System.out.println(Math.min(clockwiseCost, counterClockwiseCost));

        sc.close();
    }
}