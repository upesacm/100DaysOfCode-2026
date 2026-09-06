#include <stdlib.h>
#include <string.h>

int largestPathValue(char* colors, int** edges, int edgesSize, int* edgesColSize) {
    int n = strlen(colors);

    // Adjacency list
    int* head = malloc(n * sizeof(int));
    int* to = malloc(edgesSize * sizeof(int));
    int* next = malloc(edgesSize * sizeof(int));

    for (int i = 0; i < n; i++)
        head[i] = -1;

    int edgeCount = 0;

    // Indegree of every node
    int* indegree = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++) {
        int u = edges[i][0];
        int v = edges[i][1];

        to[edgeCount] = v;
        next[edgeCount] = head[u];
        head[u] = edgeCount++;

        indegree[v]++;
    }

    // dp[node][color]
    // Maximum number of occurrences of a color
    // on a path ending at this node.
    int (*dp)[26] = calloc(n, sizeof(*dp));

    // Queue for topological sorting
    int* queue = malloc(n * sizeof(int));
    int front = 0, rear = 0;

    // Nodes with indegree 0 are starting points
    for (int i = 0; i < n; i++) {
        if (indegree[i] == 0)
            queue[rear++] = i;
    }

    int processed = 0;
    int answer = 0;

    while (front < rear) {
        int u = queue[front++];
        processed++;

        int currentColor = colors[u] - 'a';

        // This node itself contributes 1 to its color
        dp[u][currentColor]++;

        // Update answer
        for (int c = 0; c < 26; c++) {
            if (dp[u][c] > answer)
                answer = dp[u][c];
        }

        // Visit all neighbors
        for (int e = head[u]; e != -1; e = next[e]) {
            int v = to[e];

            // Pass DP values from u to v
            for (int c = 0; c < 26; c++) {
                if (dp[u][c] > dp[v][c])
                    dp[v][c] = dp[u][c];
            }

            indegree[v]--;

            if (indegree[v] == 0)
                queue[rear++] = v;
        }
    }

    if (processed != n)
        answer = -1;

    free(head);
    free(to);
    free(next);
    free(indegree);
    free(dp);
    free(queue);

    return answer;
}