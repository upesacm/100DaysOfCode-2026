#include <stdio.h>
#define MAX 1005
int graph[MAX][MAX];
int visited[MAX];
int dfs(int node, int n, int T) 
{
    visited[node]=1;
    int count=1;
    int feet=0;
    for (int i=1;i<=n;i++) 
    {
        if (graph[node][i] && !visited[i] && feet<T) 
        {
            visited[i]=1;
            count++;
            feet++;
        }
    }
    return count;
}
int main() 
{
    int N,M,T;
    scanf("%d %d %d", &N, &M, &T);
    for (int i=0;i<M;i++) 
    {
        int u,v;
        scanf("%d %d", &u, &v);
        graph[u][v] = 1;
        graph[v][u] = 1;
    }
    int answer=0;
    for (int i=1;i<=N;i++) 
    {
        if (!visited[i]) 
        {
            int size=dfs(i,N,T);
            if (size>1)
                answer+=size;
        }
    }
    printf("%d\n",answer);
    return 0;
}