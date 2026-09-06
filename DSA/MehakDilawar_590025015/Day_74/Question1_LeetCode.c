int find(int parent[], int x) {
    if (parent[x] != x)
        parent[x] = find(parent, parent[x]);
    return parent[x];
}

long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize) {
    int *parent = malloc(n * sizeof(int));
    int *size = malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
    }
    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        int pu = find(parent, u);
        int pv = find(parent, v);
        if (pu != pv) {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    long long ans = 0;
    long long previous = 0;
    for (int i = 0; i < n; i++) {
        if (parent[i] == i) {
            ans += previous * size[i];
            previous += size[i];
        }
    }
    free(parent);
    free(size);

    return ans;
}