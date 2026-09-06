#include <stdio.h>
#include <string.h>

#define MAX 1005

int graph[MAX][MAX];
int degree[MAX];

int main()
{
    int C = 1;
    int N = 4;
    int T = 1;
    int M = 2;

    int edges[][2] = {
        {1, 2},
        {3, 4}
    };

    for (int i = 0; i < M; i++)
    {
        int u = edges[i][0];
        int v = edges[i][1];

        graph[u][degree[u]++] = v;
        graph[v][degree[v]++] = u;
    }

    int used[MAX] = {0};
    int covered = 0;

    for (int head = 1; head <= N; head++)
    {
        if (used[head])
            continue;

        int feet = 0;

        for (int i = 0; i < degree[head] && feet < T; i++)
        {
            int node = graph[head][i];

            if (!used[node])
            {
                used[node] = 1;
                feet++;
                covered++;
            }
        }

        if (feet > 0)
        {
            used[head] = 1;
            covered++;
        }
    }

    printf("%d\n", covered);

    return 0;
}