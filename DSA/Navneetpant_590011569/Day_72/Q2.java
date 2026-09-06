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

    public static int kruskals(int gNodes, List<Integer> gFrom,
                               List<Integer> gTo, List<Integer> gWeight) {

        int m = gFrom.size();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(
                gFrom.get(i),
                gTo.get(i),
                gWeight.get(i)
            ));
        }

        // Sort by weight, then by u + v + w
        edges.sort((a, b) -> {
            if (a.w != b.w) {
                return Integer.compare(a.w, b.w);
            }

            int sumA = a.u + a.v + a.w;
            int sumB = b.u + b.v + b.w;

            return Integer.compare(sumA, sumB);
        });

        parent = new int[gNodes + 1];
        rank = new int[gNodes + 1];

        for (int i = 1; i <= gNodes; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {

            if (union(edge.u, edge.v)) {
                totalWeight += edge.w;
                edgesUsed++;

                if (edgesUsed == gNodes - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}