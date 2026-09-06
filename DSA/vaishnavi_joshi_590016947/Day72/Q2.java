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

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }

        return true;
    }

    public static int kruskals(int n, int[][] edges) {

        List<Edge> list = new ArrayList<>();

        for (int[] e : edges) {
            list.add(new Edge(e[0], e[1], e[2]));
        }

        // First sort by weight.
        // If weights are equal, use u + v + w as tie breaker.
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
        }

        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge e : list) {

            // Add only if it does not create a cycle
            if (union(e.u, e.v)) {
                totalWeight += e.w;
                edgesUsed++;

                // MST needs exactly n - 1 edges
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}