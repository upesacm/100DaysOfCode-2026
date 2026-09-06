#include <stdlib.h>
#include <string.h>
int largestPathValue(char *colors,int** edges,int edgesSize,int* edgesColSize){
    int n=strlen(colors);
    int *indegree=calloc(n,sizeof(int));
    int **graph=malloc(n*sizeof(int*));
    int *count=calloc(n*26,sizeof(int));
    int *queue=malloc(n*sizeof(int));
    int *size=calloc(n,sizeof(int));
    for(int i=0;i<n;i++) graph[i]=malloc(n*sizeof(int));
    for(int i=0;i<edgesSize;i++){
        int u=edges[i][0],v=edges[i][1];
        graph[u][size[u]++]=v;
        indegree[v]++;
    }
    int front=0,rear=0;
    for(int i=0;i<n;i++){
        if(indegree[i]==0){
            queue[rear++]=i;
            count[i*26+colors[i]-'a']=1;
        }
    }
    int processed=0,ans=0;
    while(front<rear){
        int u=queue[front++];
        processed++;
        for(int c=0;c<26;c++)
            if(count[u*26+c]>ans) ans=count[u*26+c];
        for(int j=0;j<size[u];j++){
            int v=graph[u][j];
            for(int c=0;c<26;c++){
                int val=count[u*26+c]+(c==colors[v]-'a');
                if(val>count[v*26+c]) count[v*26+c]=val;
            }
            if(--indegree[v]==0) queue[rear++]=v;
        }
    }
    for(int i=0;i<n;i++) free(graph[i]);
    free(graph);
    free(indegree);
    free(count);
    free(queue);
    free(size);
    return processed==n?ans:-1;
}