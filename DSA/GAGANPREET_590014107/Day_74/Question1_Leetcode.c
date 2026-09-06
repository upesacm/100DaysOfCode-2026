long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize) {
    int parent[n];
    long long size[n];

    for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        int pu = find(u);
        int pv = find(v);

        if (pu != pv) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }

    long long ans = 0;

    for (int i = 0; i < n; i++) {
        if (parent[i] == i) {
            ans += size[i] * (n - size[i]);
        }
    }

    return ans / 2;
}
