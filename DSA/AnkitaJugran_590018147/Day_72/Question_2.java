package Graphs;

import java.util.*;

class KrushkalAlgo {

    static class Edge {
        int u;
        int v;
        int w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public String toString() {
            return u + " -- " + w + " -- " + v;
        }
    }

    static int[] parent;
    static int[] rank;

    // Find the representative of a component
    static int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        // Path compression
        parent[x] = find(parent[x]);

        return parent[x];
    }

    // Union two components
    static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        // Union by rank
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
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes and edges:");

        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];

        System.out.println("Enter each edge as: u v weight");

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        // Sort edges
        Arrays.sort(edges, (a, b) -> {

            // First priority: smaller weight
            if (a.w != b.w) {
                return Integer.compare(a.w, b.w);
            }

            // If weights are equal:
            // smaller u + v + w
            int sumA = a.u + a.v + a.w;
            int sumB = b.u + b.v + b.w;

            return Integer.compare(sumA, sumB);
        });

        System.out.println("\nEdges after sorting:");

        for (Edge edge : edges) {
            System.out.println(edge);
        }

        // Initialize DSU
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        long totalWeight = 0;
        int edgesSelected = 0;

        System.out.println("\nStarting Kruskal's Algorithm...\n");

        // Kruskal's Algorithm
        for (Edge edge : edges) {

            int rootU = find(edge.u);
            int rootV = find(edge.v);

            System.out.println("Checking edge: " + edge);

            // Different components → no cycle
            if (rootU != rootV) {

                System.out.println("  No cycle -> Edge ACCEPTED");

                totalWeight += edge.w;

                union(rootU, rootV);

                edgesSelected++;

                System.out.println("  Current MST weight: " + totalWeight);
                System.out.println("  Edges selected: " + edgesSelected);
            }
            else {

                System.out.println("  Cycle detected -> Edge REJECTED");
            }

            System.out.println();
            
            // MST has exactly n - 1 edges
            if (edgesSelected == n - 1) {
                break;
            }
        }

        System.out.println("==============================");
        System.out.println("Minimum Spanning Tree created!");
        System.out.println("Total MST Weight = " + totalWeight);
        System.out.println("Edges in MST = " + edgesSelected);
        System.out.println("==============================");

        sc.close();
    }
}