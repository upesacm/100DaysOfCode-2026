void dfs(int node, int **graph, int *graphSize, int *visited, long long *count)
{
    visited[node] = 1;
    (*count)++;

    for (int i = 0; i < graphSize[node]; i++)
    {
        int next = graph[node][i];

        if (!visited[next])
            dfs(next, graph, graphSize, visited, count);
    }
}

long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize)
{
    int **graph = malloc(n * sizeof(int *));
    int *graphSize = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++)
    {
        graphSize[edges[i][0]]++;
        graphSize[edges[i][1]]++;
    }

    for (int i = 0; i < n; i++)
        graph[i] = malloc(graphSize[i] * sizeof(int));

    int *index = calloc(n, sizeof(int));

    for (int i = 0; i < edgesSize; i++)
    {
        int u = edges[i][0];
        int v = edges[i][1];

        graph[u][index[u]++] = v;
        graph[v][index[v]++] = u;
    }

    int *visited = calloc(n, sizeof(int));

    long long answer = 0;
    long long previous = 0;

    for (int i = 0; i < n; i++)
    {
        if (!visited[i])
        {
            long long componentSize = 0;

            dfs(i, graph, graphSize, visited, &componentSize);

            answer += previous * componentSize;
            previous += componentSize;
        }
    }

    for (int i = 0; i < n; i++)
        free(graph[i]);

    free(graph);
    free(graphSize);
    free(index);
    free(visited);

    return answer;
}