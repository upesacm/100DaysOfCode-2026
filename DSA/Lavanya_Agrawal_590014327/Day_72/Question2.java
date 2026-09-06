import java.util.*;

public class Question2 {

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;
    static int[] rank;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
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

    public static long kruskal(int n, ArrayList<Edge> edges) {

        edges.sort((a, b) -> {
            if (a.w != b.w) {
                return Integer.compare(a.w, b.w);
            }

            int sumA = a.u + a.v + a.w;
            int sumB = b.u + b.v + b.w;

            return Integer.compare(sumA, sumB);
        });

        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        long totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {

            if (union(edge.u, edge.v)) {
                totalWeight += edge.w;
                edgesUsed++;

                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
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

        System.out.println(kruskal(n, edges));

        sc.close();
    }
}