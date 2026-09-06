#include <stdio.h>
#include <stdlib.h>

#define MAX 100005
#define INF 1000000000

typedef struct {
    int to;
    int cost;
} Edge;

Edge graph[MAX][2];
int degree[MAX];
int visited[MAX];
int n;

int dfs(int node) {
    visited[node] = 1;

    int count = 1;

    for (int i = 0; i < degree[node]; i++) {
        int next = graph[node][i].to;

        if (!visited[next]) {
            count += dfs(next);
        }
    }

    return count;
}

int main() {
    int m;

    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; i++) {
        int u, v, cost;
        scanf("%d %d %d", &u, &v, &cost);

        graph[u][degree[u]].to = v;
        graph[u][degree[u]].cost = 0;
        degree[u]++;

        graph[v][degree[v]].to = u;
        graph[v][degree[v]].cost = cost;
        degree[v]++;
    }

    /*
       Since the graph is a ring, after choosing a direction
       around the ring, we need all edges to point consistently
       around that ring.

       DFS calculates the cost of choosing each direction.
    */

    int minCost = INF;

    for (int start = 1; start <= n; start++) {
        int cost = 0;

        for (int i = 0; i <= n; i++)
            visited[i] = 0;

        int current = start;
        int previous = -1;

        while (!visited[current]) {
            visited[current] = 1;

            int found = 0;

            for (int j = 0; j < degree[current]; j++) {
                int next = graph[current][j].to;

                if (next != previous && !visited[next]) {
                    cost += graph[current][j].cost;
                    previous = current;
                    current = next;
                    found = 1;
                    break;
                }
            }

            if (!found)
                break;
        }

        if (cost < minCost)
            minCost = cost;
    }

    printf("%d\n", minCost);

    return 0;
}