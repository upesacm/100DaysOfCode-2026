#include <stdlib.h>

int minCost(int n, int roads[][3], int m) {
    int **graph = malloc(n * sizeof(int *));
    
    for (int i = 0; i < n; i++)
        graph[i] = calloc(n, sizeof(int));

    for (int i = 0; i < m; i++) {
        int u = roads[i][0] - 1;
        int v = roads[i][1] - 1;
        int cost = roads[i][2];

        graph[u][v] = cost;
    }

    int answer = 1000000000;

    for (int start = 0; start < n; start++) {
        int cost = 0;
        int current = start;

        for (int i = 0; i < n; i++) {
            int next = (current + 1) % n;

            if (graph[current][next] == 0)
                cost++;

            current = next;
        }

        if (cost < answer)
            answer = cost;
    }

    for (int i = 0; i < n; i++)
        free(graph[i]);

    free(graph);

    return answer;
}