import java.util.*;

public class Question2 {

    static class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }

            return parent[node];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, (a, b) -> {
            if (a.w != b.w) {
                return a.w - b.w;
            }

            return (a.u + a.v + a.w) - (b.u + b.v + b.w);
        });

        DSU dsu = new DSU(n);

        int totalWeight = 0;
        int count = 0;

        for (Edge edge : edges) {

            if (dsu.union(edge.u, edge.v)) {
                totalWeight += edge.w;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        System.out.println(totalWeight);
    }
}