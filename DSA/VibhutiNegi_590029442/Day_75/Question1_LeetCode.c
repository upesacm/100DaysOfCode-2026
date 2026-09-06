int largestPathValue(char *colors, int** edges, int edgesSize, int* edgesColSize) {
    int n = strlen(colors);
    int **graph = malloc(n * sizeof(int *));
    int *degree = calloc(n, sizeof(int));
    for (int i = 0; i < edgesSize; i++)
        degree[edges[i][0]]++;
    for (int i = 0; i < n; i++)
        graph[i] = malloc(degree[i] * sizeof(int));
    for (int i = 0; i < n; i++)
        degree[i] = 0;
    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        graph[u][degree[u]++] = v;
    }
    int **dp = malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
        dp[i] = calloc(26, sizeof(int));
    int *indegree = calloc(n, sizeof(int));
    for (int i = 0; i < edgesSize; i++)
        indegree[edges[i][1]]++;
    int *queue = malloc(n * sizeof(int));
    int front = 0, rear = 0;
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0)
            queue[rear++] = i;
    }
    int ans = 0;
    int count = 0;
    while (front < rear) {
        int u = queue[front++];
        count++;
        int c = colors[u] - 'a';
        dp[u][c]++;
        if (dp[u][c] > ans)
            ans = dp[u][c];
        for (int i = 0; i < degree[u]; i++) {
            int v = graph[u][i];
            for (int c = 0; c < 26; c++) {
                if (dp[u][c] > dp[v][c])
                    dp[v][c] = dp[u][c];
            }
            indegree[v]--;
            if (indegree[v] == 0)
                queue[rear++] = v;
        }
    }
    if (count != n)
        ans = -1;
    for (int i = 0; i < n; i++) {
        free(graph[i]);
        free(dp[i]);
    }
    free(graph);
    free(degree);
    free(dp);
    free(indegree);
    free(queue);
    return ans;
}