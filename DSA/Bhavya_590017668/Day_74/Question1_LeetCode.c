long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize) {
    int* degree = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        degree[edges[i][0]]++;
        degree[edges[i][1]]++;
    }

    int** adj = malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++)
        adj[i] = malloc(degree[i] * sizeof(int));

    int* index = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        adj[u][index[u]++] = v;
        adj[v][index[v]++] = u;
    }

    int* visited = calloc(n, sizeof(int));
    int* stack = malloc(n * sizeof(int));

    long long ans = 0;
    long long remaining = n;

    for (int i = 0; i < n; i++) {
        if (visited[i])
            continue;

        int top = 0;
        int size = 0;

        stack[top++] = i;
        visited[i] = 1;

        while (top > 0) {
            int node = stack[--top];
            size++;

            for (int j = 0; j < degree[node]; j++) {
                int next = adj[node][j];

                if (!visited[next]) {
                    visited[next] = 1;
                    stack[top++] = next;
                }
            }
        }

        remaining -= size;
        ans += (long long)size * remaining;
    }

    for (int i = 0; i < n; i++)
        free(adj[i]);

    free(adj);
    free(degree);
    free(index);
    free(visited);
    free(stack);

    return ans;
}