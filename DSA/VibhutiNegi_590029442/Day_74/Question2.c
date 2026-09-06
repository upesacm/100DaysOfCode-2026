#include <stdio.h>
#include <string.h>
#define MAX 105
int graph[MAX][MAX];
int match[MAX];
int visited[MAX];
int N, T;
int dfs(int u) {
    for (int v = 1; v <= N; v++) {
        if (graph[u][v] && !visited[v]) {
            visited[v] = 1;
            if (match[v] == 0 || dfs(match[v])) {
                match[v] = u;
                return 1;
            }
        }
    }
    return 0;
}
int main() {
    int C;
    scanf("%d", &C);
    while (C--) {
        int M;
        scanf("%d %d %d", &N, &T, &M);
        memset(graph, 0, sizeof(graph));
        for (int i = 0; i < M; i++) {
            int u, v;
            scanf("%d %d", &u, &v);
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        int answer = 0;
        for (int head = 1; head <= N; head++) {
            memset(match, 0, sizeof(match));
            int feet = 0;
            for (int v = 1; v <= N; v++) {
                if (graph[head][v]) {
                    memset(visited, 0, sizeof(visited));
                    if (dfs(v)) {
                        feet++;
                        if (feet == T)
                            break;
                    }
                }
            }
            if (feet > 0)
                answer = (answer > feet + 1)
                         ? answer
                         : feet + 1;
        }
        printf("%d\n", answer);
    }
    return 0;
}