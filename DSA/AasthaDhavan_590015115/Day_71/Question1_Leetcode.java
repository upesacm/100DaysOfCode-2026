class Solution {
    public int findJudge(int n, int[][] trust) {
        int len=trust.length;
        if(len<n-1){
            return -1;
        }
        int []indeg=new int[n+1];
        int []outdeg=new int[n+1];
    for(int i=0;i<len;i++){
        outdeg[trust[i][0]]++; //in
        indeg[trust[i][1]]++; //out
    }

    for(int i=1;i<=n;i++){
        if(outdeg[i]==0 && indeg[i]==n-1){
            return i;
        }
    }
    return -1;
    }
}