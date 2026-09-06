#include <stdio.h>
int graph[1005][1005];
int visited[1005];
int dfs(int node,int n) 
{
    visited[node]=1;
    int size=1;
    for (int i=1;i<=n;i++) {
        if (graph[node][i]&&!visited[i]) 
        {
            size+=dfs(i,n);
        }
    }
    return size;
}
void solve(int n,int m,int edges[][2]) {
    for (int i=0;i<m;i++) {
        int u=edges[i][0];
        int v=edges[i][1];
        graph[u][v]=1;
        graph[v][u]=1;
    }
    int clusters=0;
    int largest=0;
    for (int i=1;i<=n;i++) 
    {
        if (!visited[i]) 
        {
            int size=dfs(i,n);
            clusters++;
            if (size>largest)
                largest=size;
        }
    }
    printf("%d %d", clusters,largest);
}