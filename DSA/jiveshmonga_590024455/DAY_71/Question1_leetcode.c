int findJudge(int n, int** trust, int trustSize, int* trustColSize) {
    int indegree[n+1];
    int outdegree[n+1];
    for (int i=0;i<=n;i++) {
        indegree[i]=0;
        outdegree[i]=0;
    }
    for (int i=0;i<trustSize;i++) {
        int a=trust[i][0];
        int b=trust[i][1];
        outdegree[a]++;
        indegree[b]++;
    }
    for (int i=1;i<=n;i++) 
    {
        if (indegree[i]==n-1&&outdegree[i]==0)
            return i;
    }
    return -1;
}