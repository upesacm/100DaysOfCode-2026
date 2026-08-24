int findJudge(int n,int** trust,int trustSize,int* trustColSize){
    int i[n+1],u[n+1];
    for(int j=0;j<=n;j++){
        i[j]=0;
        u[j]=0;
    }
    for(int j=0;j<trustSize;j++){
        int a=trust[j][0],b=trust[j][1];
        u[a]++;
        i[b]++;
    }
    for(int j=1;j<=n;j++) if(i[j]==n-1&&u[j]==0)return j;
    return -1;
}
