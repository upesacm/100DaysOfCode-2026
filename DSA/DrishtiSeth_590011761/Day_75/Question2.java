import java.util.*;

public class Main {

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

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Edge[] edges = new Edge[n];

        // Undirected adjacency list to reconstruct the ring
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int cost = sc.nextInt();

            edges[i] = new Edge(a, b, cost);

            graph.get(a).add(i);
            graph.get(b).add(i);
        }

        // Construct the order of nodes around the ring
        int[] order = new int[n];

        order[0] = 0;

        // Start from one of the two neighbours
        int firstEdgeIndex = graph.get(0).get(0);
        Edge firstEdge = edges[firstEdgeIndex];

        int current;

        if (firstEdge.from == 0) {
            current = firstEdge.to;
        } else {
            current = firstEdge.from;
        }

        int previous = 0;
        order[1] = current;

        for (int i = 2; i < n; i++) {

            int next = -1;

            for (int edgeIndex : graph.get(current)) {

                Edge edge = edges[edgeIndex];

                int neighbour =
                        (edge.from == current)
                                ? edge.to
                                : edge.from;

                if (neighbour != previous) {
                    next = neighbour;
                    break;
                }
            }

            previous = current;
            current = next;

            order[i] = current;
        }

        // Calculate cost for both possible directions
        int costForward = 0;
        int costBackward = 0;

        for (int i = 0; i < n; i++) {

            int u = order[i];
            int v = order[(i + 1) % n];

            Edge road = findEdge(u, v, graph, edges);

            // Desired direction: u -> v
            if (road.from != u || road.to != v) {
                costForward += road.cost;
            }

            // Desired direction: v -> u
            if (road.from != v || road.to != u) {
                costBackward += road.cost;
            }
        }

        System.out.println(Math.min(costForward, costBackward));

        sc.close();
    }

    static Edge findEdge(
            int u,
            int v,
            List<List<Integer>> graph,
            Edge[] edges) {

        for (int edgeIndex : graph.get(u)) {

            Edge edge = edges[edgeIndex];

            if ((edge.from == u && edge.to == v) ||
                (edge.from == v && edge.to == u)) {

                return edge;
            }
        }

        return null;
    }
}
