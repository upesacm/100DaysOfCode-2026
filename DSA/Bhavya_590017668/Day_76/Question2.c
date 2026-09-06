#include <stdlib.h>
#include <stdbool.h>

bool hasEulerTrail(int n,int** edges,int m,int* deg){
    if(m==0) return true;
    int odd=0;
    for(int i=0;i<n;i++){
        if(deg[i]%2) odd++;
        if(odd>2) return false;
    }
    int start=-1;
    for(int i=0;i<n;i++){
        if(deg[i]>0){
            start=i;
            break;
        }
    }
    if(start==-1) return true;
    int* vis=calloc(n,sizeof(int));
    int* q=malloc(n*sizeof(int));
    int front=0,rear=0;
    q[rear++]=start;
    vis[start]=1;
    while(front<rear){
        int u=q[front++];
        for(int i=0;i<m;i++){
            int v=-1;
            if(edges[i][0]==u) v=edges[i][1];
            else if(edges[i][1]==u) v=edges[i][0];
            if(v!=-1&&!vis[v]){
                vis[v]=1;
                q[rear++]=v;
            }
        }
    }
    for(int i=0;i<n;i++){
        if(deg[i]>0&&!vis[i]){
            free(vis);
            free(q);
            return false;
        }
    }
    free(vis);
    free(q);
    return true;
}

int kthLineGraphEulerTrail(int n,int** edges,int edgesSize,int k,int* edgesColSize){
    int* deg=calloc(n,sizeof(int));
    for(int i=0;i<edgesSize;i++){
        deg[edges[i][0]]++;
        deg[edges[i][1]]++;
    }
    if(k==0){
        int odd=0;
        for(int i=0;i<n;i++) odd+=deg[i]%2;
        free(deg);
        return odd==0||odd==2;
    }
    int* curDeg=deg;
    int curN=n;
    int curM=edgesSize;
    int** curEdges=edges;
    for(int step=0;step<k;step++){
        int newN=curM;
        int* newDeg=calloc(newN,sizeof(int));
        for(int i=0;i<curM;i++){
            int u=curEdges[i][0];
            int v=curEdges[i][1];
            newDeg[i]=curDeg[u]+curDeg[v]-2;
        }
        int newM=0;
        for(int v=0;v<curN;v++){
            int count=0;
            for(int i=0;i<curM;i++){
                if(curEdges[i][0]==v||curEdges[i][1]==v) count++;
            }
            newM+=count*(count-1)/2;
        }
        if(step==k-1){
            int odd=0;
            for(int i=0;i<newN;i++){
                if(newDeg[i]%2) odd++;
            }
            free(newDeg);
            free(curDeg);
            return odd==0||odd==2;
        }
        free(newDeg);
        break;
    }
    free(curDeg);
    return 0;
}