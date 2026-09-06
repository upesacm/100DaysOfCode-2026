//Given an undirected graph, find the maximum number of vertices that can be covered by vertex-disjoint crab subgraphs, 
//where each crab has one head connected to up to T feet.
//Input: C = 1, N = 4, T = 1, M = 2, edges = [[1,2],[3,4]]. Output: 4
#include <stdio.h>

int main() {
    int C, N, T, M;
    printf("Enter C, N, T, M: ");
    scanf("%d %d %d %d", &C, &N, &T, &M);
    int edges[M][2];
    printf("Enter %d edges:\n", M);
    for (int i = 0; i < M; i++) {
        scanf("%d %d", &edges[i][0], &edges[i][1]);
    }
    int used[N + 1];
    for (int i = 0; i <= N; i++)
        used[i] = 0;
    int covered = 0;
    for (int i = 0; i < M; i++) {
        int u = edges[i][0];
        int v = edges[i][1];
        if (!used[u] && !used[v]) {
            used[u] = 1;
            used[v] = 1;
            covered += 2;
        }
    }
    printf("Maximum vertices covered = %d\n", covered);
return 0;
}
