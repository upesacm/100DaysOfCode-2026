#include <stdio.h>
#include <stdlib.h>

#define MAX 100005

int graph[MAX][20];
int degree[MAX];
int used[MAX];

int main() {
    int C, N, T, M;

    scanf("%d %d %d %d", &C, &N, &T, &M);

    for (int i = 0; i < M; i++) {
        int u, v;
        scanf("%d %d", &u, &v);

        graph[u][degree[u]++] = v;
        graph[v][degree[v]++] = u;
    }

    int covered = 0;

    /*
       Try every vertex as a possible head.
       Give it as many unused neighbors as possible,
       up to T.
    */
    for (int i = 1; i <= N; i++) {

        if (used[i])
            continue;

        int feet = 0;

        for (int j = 0; j < degree[i] && feet < T; j++) {
            int neighbor = graph[i][j];

            if (!used[neighbor]) {
                used[neighbor] = 1;
                feet++;
            }
        }

        if (feet > 0) {
            used[i] = 1;
            covered += 1 + feet;
        }
    }

    printf("%d\n", covered);

    return 0;
}