import java.util.*;

class Solution {

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

    // Find the representative of a set
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Join two sets
    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // Already connected -> adding this edge creates a cycle
        if (rootA == rootB) {
            return false;
        }

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } 
        else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } 
        else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }

        return true;
    }

    public static int kruskals(int n, List<List<Integer>> edges) {

        List<Edge> list = new ArrayList<>();

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);

            list.add(new Edge(u, v, w));
        }

        // Sort by:
        // 1. Weight
        // 2. u + v + w for equal weights
        Collections.sort(list, (a, b) -> {

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
            rank[i] = 0;
        }

        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : list) {

            if (union(edge.u, edge.v)) {

                totalWeight += edge.w;
                edgesUsed++;

                // MST contains exactly n - 1 edges
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}
