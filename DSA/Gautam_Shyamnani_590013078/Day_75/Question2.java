import java.util.*;

public class Question2 {

    static class Edge {
        int city, cost;

        Edge(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Map<String, Integer> direction = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));

            direction.put(a + "," + b, cost);
        }

        int[] ring = new int[n];

        ring[0] = 1;
        int previous = -1;
        int current = 1;

        for (int i = 1; i < n; i++) {
            for (Edge edge : graph[current]) {
                if (edge.city != previous) {
                    ring[i] = edge.city;
                    previous = current;
                    current = edge.city;
                    break;
                }
            }
        }

        long clockwiseCost = 0;
        long counterClockwiseCost = 0;

        for (int i = 0; i < n; i++) {
            int from = ring[i];
            int to = ring[(i + 1) % n];

            if (!direction.containsKey(from + "," + to)) {
                clockwiseCost += direction.get(to + "," + from);
            }

            if (!direction.containsKey(to + "," + from)) {
                counterClockwiseCost += direction.get(from + "," + to);
            }
        }

        System.out.println(Math.min(clockwiseCost, counterClockwiseCost));
    }
}