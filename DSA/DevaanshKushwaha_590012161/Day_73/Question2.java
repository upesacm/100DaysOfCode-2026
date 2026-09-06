class Solution {
    private int[] parent, rank_, size_;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;

        if (rank_[rootX] < rank_[rootY]) {
            int temp = rootX; rootX = rootY; rootY = temp;
        }
        parent[rootY] = rootX;
        size_[rootX] += size_[rootY];
        if (rank_[rootX] == rank_[rootY]) rank_[rootX]++;
    }

    public int[] wellsAndLargestCluster(int n, int m, int[][] edges) {
        parent = new int[n + 1];
        rank_ = new int[n + 1];
        size_ = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size_[i] = 1;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        int wells = 0;
        int largestCluster = 0;

        for (int i = 1; i <= n; i++) {
            if (find(i) == i) { // root of a component
                wells++;
                largestCluster = Math.max(largestCluster, size_[i]);
            }
        }

        return new int[]{wells, largestCluster};
    }
}
