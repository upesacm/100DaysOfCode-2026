import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int u, v, w;
        long sum;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
            this.sum = (long) u + v + w;
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

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
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

    static long kruskal(int n, Edge[] edges) {

        Arrays.sort(edges, (a, b) -> {

            if (a.w != b.w) {
                return Integer.compare(a.w, b.w);
            }

            if (a.sum != b.sum) {
                return Long.compare(a.sum, b.sum);
            }

            if (a.u != b.u) {
                return Integer.compare(a.u, b.u);
            }

            return Integer.compare(a.v, b.v);
        });

        DSU dsu = new DSU(n);

        long totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {

            if (dsu.union(edge.u, edge.v)) {

                totalWeight += edge.w;
                edgesUsed++;

                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];

        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        System.out.println(kruskal(n, edges));
    }
}