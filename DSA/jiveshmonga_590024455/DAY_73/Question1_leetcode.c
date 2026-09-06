#include <limits.h>
#include <stdlib.h>

void getDistances(int *edges,int n,int start,int *dist) 
{
    int current=start;
    int d=0;
    while (current!=-1&&dist[current]==-1) 
    {
        dist[current]=d;
        d++;
        current=edges[current];
    }
}
int closestMeetingNode(int* edges,int edgesSize,int node1,int node2) 
{
    int n=edgesSize;
    int *dist1=(int *)malloc(n * sizeof(int));
    int *dist2=(int *)malloc(n * sizeof(int));
    for (int i=0;i<n;i++) 
    {
        dist1[i]=-1;
        dist2[i]=-1;
    }
    getDistances(edges,n,node1,dist1);
    getDistances(edges,n,node2,dist2);
    int answer=-1;
    int best=INT_MAX;
    for (int i=0;i<n;i++) 
    {
        if (dist1[i]!=-1&&dist2[i]!=-1) 
        {
            int maximum=dist1[i]>dist2[i]?dist1[i]:dist2[i];
            if (maximum<best) 
            {
                best=maximum;
                answer=i;
            }
        }
    }
    free(dist1);
    free(dist2);
    return answer;
}