#include <stdlib.h>
int dfs(int node, int n, int **graph, int *visited) 
{
    visited[node]=1;
    int size=1;
    for (int i=0;i<n;i++) 
    {
        if (graph[node][i] && !visited[i]) 
        {
            size+=dfs(i, n, graph, visited);
        }
    }
    return size;
}
long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize) 
{
    int **graph=malloc(n * sizeof(int *));
    int *visited=calloc(n, sizeof(int));
    for (int i=0;i<n;i++)
        graph[i]=calloc(n, sizeof(int));
    for (int i=0;i<edgesSize;i++) 
    {
        int u=edges[i][0];
        int v=edges[i][1];
        graph[u][v]=1;
        graph[v][u]=1;
    }
    long long answer=0;
    int previous=0;
    for (int i=0;i<n;i++) 
    {
        if (!visited[i]) 
        {
            int size = dfs(i,n,graph,visited);
            answer+=(long long)size * previous;
            previous += size;
        }
    }
    for (int i=0;i<n;i++)
        free(graph[i]);
    free(graph);
    free(visited);
    return answer;
}