#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAXV 100
#define MAXE 10000

typedef struct {
    int u, v;
} Edge;

bool hasEulerTrail(int n, Edge edges[], int m) {
    if (m == 0)
        return true;

    int degree[MAXV] = {0};

    for (int i = 0; i < m; i++) {
        degree[edges[i].u]++;
        degree[edges[i].v]++;
    }

    // Count odd-degree vertices
    int odd = 0;

    for (int i = 0; i < n; i++) {
        if (degree[i] % 2)
            odd++;
    }

    if (odd != 0 && odd != 2)
        return false;

    // Check connectivity among non-isolated vertices
    int visited[MAXV] = {0};
    int queue[MAXV];
    int front = 0, rear = 0;

    int start = -1;

    for (int i = 0; i < n; i++) {
        if (degree[i] > 0) {
            start = i;
            break;
        }
    }

    if (start == -1)
        return true;

    queue[rear++] = start;
    visited[start] = 1;

    while (front < rear) {
        int u = queue[front++];

        for (int i = 0; i < m; i++) {
            int v = -1;

            if (edges[i].u == u)
                v = edges[i].v;
            else if (edges[i].v == u)
                v = edges[i].u;

            if (v != -1 && !visited[v]) {
                visited[v] = 1;
                queue[rear++] = v;
            }
        }
    }

    for (int i = 0; i < n; i++) {
        if (degree[i] > 0 && !visited[i])
            return false;
    }

    return true;
}

/*
   Construct line graph.

   Every edge of G becomes a vertex in L(G).
   Two vertices in L(G) are connected when
   their corresponding edges in G share a vertex.
*/
void lineGraph(int *n, Edge edges[], int *m) {

    int oldN = *n;
    int oldM = *m;

    Edge newEdges[MAXE];
    int newM = 0;

    for (int i = 0; i < oldM; i++) {
        for (int j = i + 1; j < oldM; j++) {

            if (edges[i].u == edges[j].u ||
                edges[i].u == edges[j].v ||
                edges[i].v == edges[j].u ||
                edges[i].v == edges[j].v) {

                newEdges[newM].u = i;
                newEdges[newM].v = j;
                newM++;
            }
        }
    }

    for (int i = 0; i < newM; i++)
        edges[i] = newEdges[i];

    *n = oldM;
    *m = newM;
}

bool kthLineGraphEulerTrail(
    int n,
    Edge edges[],
    int m,
    int k
) {
    for (int i = 0; i < k; i++) {
        lineGraph(&n, edges, &m);
    }

    return hasEulerTrail(n, edges, m);
}

int main() {

    int n = 4;
    int m = 4;

    Edge edges[] = {
        {0, 1},
        {1, 2},
        {2, 3},
        {3, 0}
    };

    int k = 1;

    if (kthLineGraphEulerTrail(n, edges, m, k))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}
