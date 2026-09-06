#define MAXC 26

int largestPathValue(char *colors, int** edges, int edgesSize, int* edgesColSize) {
    int n = strlen(colors);

    int **graph = (int **)malloc(n * sizeof(int *));
    int *degree = (int *)calloc(n, sizeof(int));
    int *count = (int *)calloc(n, sizeof(int));

    for (int i = 0; i < n; i++)
        graph[i] = NULL;

    // Count outgoing edges
    int *out = (int *)calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        out[edges[i][0]]++;
        degree[edges[i][1]]++;
    }

    for (int i = 0; i < n; i++) {
        if (out[i] > 0)
            graph[i] = (int *)malloc(out[i] * sizeof(int));
    }

    int *pos = (int *)calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        graph[u][pos[u]++] = v;
    }

    // dp[node][color]
    int (*dp)[MAXC] = calloc(n, sizeof(*dp));

    int *queue = (int *)malloc(n * sizeof(int));
    int front = 0, rear = 0;

    // Nodes with indegree 0
    for (int i = 0; i < n; i++) {
        if (degree[i] == 0)
            queue[rear++] = i;
    }

    int processed = 0;
    int answer = 0;

    while (front < rear) {
        int u = queue[front++];
        processed++;

        int c = colors[u] - 'a';
        dp[u][c]++;

        for (int j = 0; j < out[u]; j++) {
            int v = graph[u][j];

            for (int k = 0; k < MAXC; k++) {
                if (dp[v][k] < dp[u][k])
                    dp[v][k] = dp[u][k];
            }

            degree[v]--;

            if (degree[v] == 0)
                queue[rear++] = v;
        }

        for (int k = 0; k < MAXC; k++) {
            if (dp[u][k] > answer)
                answer = dp[u][k];
        }
    }

    // If not all nodes were processed, graph contains a cycle
    if (processed != n)
        answer = -1;

    for (int i = 0; i < n; i++)
        free(graph[i]);

    free(graph);
    free(degree);
    free(count);
    free(out);
    free(pos);
    free(dp);
    free(queue);

    return answer;
}
