#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int u, v;
} Edge;

/* Check whether an undirected graph has an Euler trail */
int hasEulerTrail(int n, int m, Edge edges[]) {
    if (m == 0)
        return 1;

    int *degree = calloc(n, sizeof(int));
    int *visited = calloc(n, sizeof(int));
    int *queue = malloc(n * sizeof(int));

    /* Calculate degrees */
    for (int i = 0; i < m; i++) {
        degree[edges[i].u]++;
        degree[edges[i].v]++;
    }

    /* Find a vertex with non-zero degree */
    int start = -1;

    for (int i = 0; i < n; i++) {
        if (degree[i] > 0) {
            start = i;
            break;
        }
    }

    if (start == -1) {
        free(degree);
        free(visited);
        free(queue);
        return 1;
    }

    /* Check connectivity */
    int front = 0, rear = 0;
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
        if (degree[i] > 0 && !visited[i]) {
            free(degree);
            free(visited);
            free(queue);
            return 0;
        }
    }

    /* Euler trail exists if there are 0 or 2 odd-degree vertices */
    int odd = 0;

    for (int i = 0; i < n; i++) {
        if (degree[i] % 2 != 0)
            odd++;
    }

    free(degree);
    free(visited);
    free(queue);

    return odd == 0 || odd == 2;
}

/*
   Construct the line graph.

   Every edge of the original graph becomes a vertex.
   Two new vertices are connected if their corresponding
   original edges share an endpoint.
*/
void makeLineGraph(int n, int m, Edge edges[],
                   int *newN, int *newM, Edge **newEdges) {

    *newN = m;

    int capacity = m * (m - 1) / 2;
    Edge *result = malloc(
        (capacity > 0 ? capacity : 1) * sizeof(Edge)
    );

    int count = 0;

    for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < m; j++) {

            if (edges[i].u == edges[j].u ||
                edges[i].u == edges[j].v ||
                edges[i].v == edges[j].u ||
                edges[i].v == edges[j].v) {

                result[count].u = i;
                result[count].v = j;
                count++;
            }
        }
    }

    *newM = count;
    *newEdges = result;
}

int main() {
    int n, m, k;

    scanf("%d %d %d", &n, &m, &k);

    Edge *edges = malloc(m * sizeof(Edge));

    for (int i = 0; i < m; i++) {
        scanf("%d %d", &edges[i].u, &edges[i].v);

        /*
           Convert 1-based input to 0-based indexing.
        */
        edges[i].u--;
        edges[i].v--;
    }

    for (int step = 0; step < k; step++) {
        int newN, newM;
        Edge *newEdges;

        makeLineGraph(
            n,
            m,
            edges,
            &newN,
            &newM,
            &newEdges
        );

        free(edges);

        edges = newEdges;
        n = newN;
        m = newM;
    }

    if (hasEulerTrail(n, m, edges))
        printf("true\n");
    else
        printf("false\n");

    free(edges);

    return 0;
}