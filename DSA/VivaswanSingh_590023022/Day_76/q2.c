#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int to;
    int cost;
    int from;
} Edge;

int minimumCost(int n, int roads[][3], int m)
{
    int *deg = calloc(n + 1, sizeof(int));
    Edge (*graph)[2] = malloc((n + 1) * sizeof(*graph));

    for (int i = 0; i < m; i++)
    {
        int u = roads[i][0];
        int v = roads[i][1];
        int cost = roads[i][2];

        graph[u][deg[u]++] = (Edge){v, cost, u};
        graph[v][deg[v]++] = (Edge){u, cost, u};
    }

    int *order = malloc(n * sizeof(int));
    int *used = calloc(n + 1, sizeof(int));

    order[0] = 1;
    used[1] = 1;

    for (int i = 1; i < n; i++)
    {
        int current = order[i - 1];

        if (!used[graph[current][0].to])
            order[i] = graph[current][0].to;
        else
            order[i] = graph[current][1].to;

        used[order[i]] = 1;
    }

    long long clockwise = 0;
    long long counterClockwise = 0;

    for (int i = 0; i < n; i++)
    {
        int u = order[i];
        int v = order[(i + 1) % n];

        for (int j = 0; j < 2; j++)
        {
            if (graph[u][j].to == v)
            {
                /*
                   graph[u][j].from == u means
                   the original road is u -> v.

                   Otherwise it is v -> u.
                */
                if (graph[u][j].from != u)
                    clockwise += graph[u][j].cost;

                break;
            }
        }
    }

    for (int i = 0; i < n; i++)
    {
        int u = order[i];
        int v = order[(i - 1 + n) % n];

        for (int j = 0; j < 2; j++)
        {
            if (graph[u][j].to == v)
            {
                if (graph[u][j].from != u)
                    counterClockwise += graph[u][j].cost;

                break;
            }
        }
    }

    long long answer = clockwise < counterClockwise
                       ? clockwise
                       : counterClockwise;

    free(deg);
    free(graph);
    free(order);
    free(used);

    return (int)answer;
}

int main()
{
    int n = 3;
    int m = 3;

    int roads[3][3] = {
        {1, 3, 1},
        {1, 2, 1},
        {3, 2, 1}
    };

    printf("%d\n", minimumCost(n, roads, m));

    return 0;
}