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

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c, true));
            graph.get(b).add(new Edge(a, c, false));
        }

        int[] order = new int[n];

        int prev = -1;
        int current = 1;

        for (int i = 0; i < n; i++) {

            order[i] = current;

            for (Edge e : graph.get(current)) {

                if (e.to != prev) {
                    prev = current;
                    current = e.to;
                    break;
                }
            }
        }

        int cost1 = 0;
        int cost2 = 0;

        for (int i = 0; i < n; i++) {

            int u = order[i];
            int v = order[(i + 1) % n];

            for (Edge e : graph.get(u)) {

                if (e.to == v) {
                    if (!e.originalDirection) {
                        cost1 += e.cost;
                    }

                    if (e.originalDirection) {
                        cost2 += e.cost;
                    }
                    break;
                }
            }
        }

        System.out.println(Math.min(cost1, cost2));
    }
}