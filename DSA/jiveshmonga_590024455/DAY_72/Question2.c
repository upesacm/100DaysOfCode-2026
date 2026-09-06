#include <stdio.h>
#include <stdlib.h>
struct Edge 
{
    int u,v,w;
};
int parent[1005];
int find(int x) {
    if (parent[x]==x)
        return x;
    return find(parent[x]);
}
void unite(int a, int b) 
{
    a=find(a);
    b=find(b);
    if (a!=b)
        parent[a]=b;
}
int compare(const void *a,const void *b) 
{
    struct Edge *e1=(struct Edge *)a;
    struct Edge *e2=(struct Edge *)b;
    return e1->w-e2->w;
}

int kruskal(int n,int m,struct Edge edges[]) 
{
    int total=0;
    int count=0;
    for (int i=1;i<=n;i++)
        parent[i]=i;
    qsort(edges, m, sizeof(struct Edge), compare);
    for (int i=0;i<m;i++) 
    {
        int a = find(edges[i].u);
        int b = find(edges[i].v);
        if (a!=b) 
        {
            unite(a, b);
            total += edges[i].w;
            count++;
            if (count==n-1)
                break;
        }
    }
    return total;
}