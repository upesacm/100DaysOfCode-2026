
import java.util.*;
class SS{
    static class Edge {
        int u; int v; int weight;
        Edge(int u, int v, int weight) {
            this.u = u; this.v = v; this.weight = weight;
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
    static int kruskal(int n, int[][] edges) {
        Edge[] edgeList = new Edge[edges.length];
        for (int i = 0; i < edges.length; i++) {
            edgeList[i] = new Edge(edges[i][0], edges[i][1], edges[i][2]);
        }
        Arrays.sort(edgeList,
            (a, b) -> a.weight - b.weight
        );
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        int total = 0;
        int edgesUsed = 0;
        for (Edge edge : edgeList) {
            if (union(edge.u, edge.v)) {
                total += edge.weight;
                edgesUsed++;
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = { {1, 2, 5}, {1, 3, 3}, {4, 1, 6}, {2, 4, 7}, {3, 2, 4}, {3, 4, 5}};
        int answer = kruskal(n, edges);
        System.out.println("Minimum Spanning Tree Weight:" + answer);
    }
}