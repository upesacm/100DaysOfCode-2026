import java.util.*;

class Question2 {

    static class Edge {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }
    static int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    static boolean union(int[] parent, int[] rank, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        if (pu == pv) {
            return false;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }
    static int kruskal(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int totalWeight = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (union(parent, rank, u, v)) {
                totalWeight += weight;
                edgesUsed++;

                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }
        return totalWeight;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 6;
        int[][] edges = {
            {1, 2, 5},
            {1, 3, 3},
            {4, 1, 6},
            {2, 4, 7},
            {3, 2, 4},
            {3, 4, 5}
        };
        System.out.println(kruskal(n, edges));
    }
}