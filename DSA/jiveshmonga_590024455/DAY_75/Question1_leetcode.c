#include <stdlib.h>
#include <string.h>

int largestPathValue(char* colors, int** edges, int edgesSize, int* edgesColSize) {
    int n = strlen(colors);

    int **graph = malloc(n * sizeof(int *));
    int *degree = calloc(n, sizeof(int));

    for (int i = 0; i < n; i++)
        graph[i] = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        degree[i] = 0;

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        graph[u][degree[u]++] = v;
    }

    int **dp = malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++) {
        dp[i] = calloc(26, sizeof(int));
        dp[i][colors[i] - 'a'] = 1;
    }

    int *queue = malloc(n * sizeof(int));
    int front = 0, rear = 0;

    int *indegree = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++)
        indegree[edges[i][1]]++;

    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0)
            queue[rear++] = i;
    }

    int processed = 0;
    int answer = 0;

    while (front < rear) {
        int u = queue[front++];
        processed++;

        for (int c = 0; c < 26; c++) {
            if (dp[u][c] > answer)
                answer = dp[u][c];
        }

        for (int j = 0; j < degree[u]; j++) {
            int v = graph[u][j];

            for (int c = 0; c < 26; c++) {
                int value = dp[u][c];

                if (c == colors[v] - 'a')
                    value++;

                if (value > dp[v][c])
                    dp[v][c] = value;
            }

            indegree[v]--;

            if (indegree[v] == 0)
                queue[rear++] = v;
        }
    }

    if (processed != n)
        answer = -1;

    for (int i = 0; i < n; i++) {
        free(graph[i]);
        free(dp[i]);
    }

    free(graph);
    free(dp);
    free(degree);
    free(indegree);
    free(queue);

    return answer;
}