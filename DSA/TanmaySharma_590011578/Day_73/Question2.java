import java.util.*;

public class Question2 {
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (size[pa] < size[pb]) {
            int temp = pa;
            pa = pb;
            pb = temp;
        }

        parent[pb] = pa;
        size[pa] += size[pb];
    }

    static void solve(int n, int m, int[][] edges, int s) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            union(edges[i][0], edges[i][1]);
        }

        int clusters = 0;
        int largestCluster = 0;

        for (int i = 1; i <= n; i++) {
            if (find(i) == i) {
                clusters++;
                largestCluster = Math.max(largestCluster, size[i]);
            }
        }

        System.out.println(clusters + " " + largestCluster);
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 3;

        int[][] edges = {
            {1, 2},
            {2, 3},
            {1, 4}
        };

        int s = 1;

        solve(n, m, edges, s);
    }
}