import java.util.*;

class Solution {
    private int[] parent, rank_;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return false; // would form a cycle

        // union by rank
        if (rank_[rootX] < rank_[rootY]) {
            parent[rootX] = rootY;
        } else if (rank_[rootX] > rank_[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank_[rootX]++;
        }
        return true;
    }

    public int minSpanningTreeWeight(int n, int m, int[][] edges) {
        // Sort edges by weight
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        parent = new int[n + 1];
        rank_ = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        int totalWeight = 0;
        int edgesUsed = 0;

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (union(u, v)) {
                totalWeight += w;
                edgesUsed++;
                if (edgesUsed == n - 1) break; // MST complete
            }
        }

        return totalWeight;
    }
}
