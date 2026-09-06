//After repeatedly converting a graph into its line graph k times, determine whether the resulting graph still has an Euler trail.
//Input:n=4, edges=[(1,2),(2,3),(3,4),(4,1)], k=1. Output:true.
#include <stdio.h>
#include <stdlib.h>
#define MAXV 100
#define MAXE 5000
typedef struct {
    int u, v;
} Edge;

int hasEulerTrail(int n, int adj[MAXV][MAXV]) {
    int odd = 0;
    for (int i = 0; i < n; i++) {
        int degree = 0;
        for (int j = 0; j < n; j++) {
            degree += adj[i][j];
        }
        if (degree % 2 != 0)
            odd++;
    }
    return (odd == 0 || odd == 2);
}

int buildLineGraph(int n, int adj[MAXV][MAXV],int newAdj[MAXE][MAXE]) {
    Edge edges[MAXE];
    int edgeCount = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (adj[i][j]) {
                edges[edgeCount].u = i;
                edges[edgeCount].v = j;
                edgeCount++;
            }
        }
    }
    for (int i = 0; i < edgeCount; i++)
        for (int j = 0; j < edgeCount; j++)
            newAdj[i][j] = 0;
    for (int i = 0; i < edgeCount; i++) {
        for (int j = i + 1; j < edgeCount; j++) {
            if (edges[i].u == edges[j].u ||
                edges[i].u == edges[j].v ||
                edges[i].v == edges[j].u ||
                edges[i].v == edges[j].v) {
                newAdj[i][j] = 1;
                newAdj[j][i] = 1;
            }
        }
    }
    return edgeCount;
}

int main() {
    int n, m, k;
    int adj[MAXV][MAXV] = {0};
    printf("Enter number of vertices: ");
    scanf("%d", &n);
    printf("Enter number of edges: ");
    scanf("%d", &m);
    printf("Enter the edges (u v):\n");
    for (int i = 0; i < m; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        u--;
        v--;
        adj[u][v] = 1;
        adj[v][u] = 1;
    }
    printf("Enter k: ");
    scanf("%d", &k);
    int vertices = n;
    for (int step = 0; step < k; step++) {
        int newAdj[MAXE][MAXE];
        vertices = buildLineGraph(vertices, adj, newAdj);
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adj[i][j] = newAdj[i][j];
            }
        }
    }
    if (hasEulerTrail(vertices, adj))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}