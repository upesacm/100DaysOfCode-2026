#include <stdio.h>

#define MAX 100005

int graph[MAX][10];
int degree[MAX];
int visited[MAX];
int n;

long long dfs(int node) {
    visited[node] = 1;

    long long size = 1;

    for (int i = 0; i < degree[node]; i++) {
        int next = graph[node][i];

        if (!visited[next]) {
            size += dfs(next);
        }
    }

    return size;
}

int main() {
    int m;

    scanf("%d", &n);
    scanf("%d", &m);

    for (int i = 0; i < m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);

        graph[a][degree[a]++] = b;
        graph[b][degree[b]++] = a;
    }

    long long answer = 0;
    long long remaining = n;

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            long long size = dfs(i);

            
            answer += size * (remaining - size);

            remaining -= size;
        }
    }

    printf("%lld\n", answer);

    return 0;
}