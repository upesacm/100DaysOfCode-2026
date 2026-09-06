class Solution {
    private void dfs(int curr,int dis,int[] e,int []d){
        while(curr!=-1 && d[curr]==-1){
            d[curr]=dis++;
            curr=e[curr];
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int res=-1;
        int n=edges.length;
        int maxi=Integer.MAX_VALUE;
        int []d1=new int[n];
        int []d2=new int[n];
        Arrays.fill(d1,-1);
        Arrays.fill(d2,-1);
        dfs(node1,0,edges,d1);
        dfs(node2,0,edges,d2);
        for(int i=0;i<n;i++){
            if(d1[i]>=0 && d2[i]>=0){
                int maxd=Math.max(d1[i],d2[i]);
                if(maxd<maxi){
                    maxi=maxd;
                    res=i;
                }
            }
        }
        return res;
    }
}