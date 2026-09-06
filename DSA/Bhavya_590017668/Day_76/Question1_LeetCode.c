#include <stdlib.h>
#define MOD 1000000007

long long modPow(long long a,long long b){
    long long res=1;
    while(b){
        if(b&1) res=res*a%MOD;
        a=a*a%MOD;
        b>>=1;
    }
    return res;
}

int waysToBuildRooms(int* prevRoom,int prevRoomSize){
    int n=prevRoomSize;
    int *size=calloc(n,sizeof(int));
    long long *dp=calloc(n,sizeof(long long));
    long long *fact=malloc(n*sizeof(long long));
    long long *invFact=malloc(n*sizeof(long long));
    int *childCount=calloc(n,sizeof(int));
    int *pos=calloc(n,sizeof(int));
    int *order=malloc(n*sizeof(int));
    int *stack=malloc(n*sizeof(int));
    
    fact[0]=1;
    for(int i=1;i<n;i++) fact[i]=fact[i-1]*i%MOD;
    
    invFact[n-1]=modPow(fact[n-1],MOD-2);
    for(int i=n-1;i>0;i--) invFact[i-1]=invFact[i]*i%MOD;
    
    for(int i=1;i<n;i++) childCount[prevRoom[i]]++;
    
    int **children=malloc(n*sizeof(int*));
    for(int i=0;i<n;i++)
        children[i]=childCount[i]?malloc(childCount[i]*sizeof(int)):NULL;
    
    for(int i=1;i<n;i++)
        children[prevRoom[i]][pos[prevRoom[i]]++]=i;
    
    int top=0,ord=0;
    stack[top++]=0;
    
    while(top){
        int u=stack[--top];
        order[ord++]=u;
        for(int i=0;i<childCount[u];i++)
            stack[top++]=children[u][i];
    }
    
    for(int k=n-1;k>=0;k--){
        int u=order[k];
        size[u]=1;
        dp[u]=1;
        int total=0;
        
        for(int i=0;i<childCount[u];i++){
            int c=children[u][i];
            long long ways=fact[total+size[c]];
            ways=ways*invFact[total]%MOD;
            ways=ways*invFact[size[c]]%MOD;
            dp[u]=dp[u]*dp[c]%MOD;
            dp[u]=dp[u]*ways%MOD;
            total+=size[c];
        }
        
        size[u]=total+1;
    }
    
    int ans=dp[0];
    
    for(int i=0;i<n;i++)
        free(children[i]);
    
    free(children);
    free(size);
    free(dp);
    free(fact);
    free(invFact);
    free(childCount);
    free(pos);
    free(order);
    free(stack);
    
    return ans;
}