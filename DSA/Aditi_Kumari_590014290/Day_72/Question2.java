package DSA.Aditi_Kumari_590014290.Day_72;

import java.util.*;

public class Question2 {

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    static void union(int[] parent, int[] rank, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        if (pu == pv) {
            return;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
    }

    static int kruskal(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int totalWeight = 0;
        int count = 0;

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (find(parent, u) != find(parent, v)) {
                union(parent, rank, u, v);
                totalWeight += weight;
                count++;

                if (count == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }
}