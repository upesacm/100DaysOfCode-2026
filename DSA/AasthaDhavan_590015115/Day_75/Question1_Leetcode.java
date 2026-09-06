class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        List<Integer> g[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        int[] id=new int[n];
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            g[u].add(v);
            id[v]++;
        }

        int[][] dp=new int[n][26];
        Queue<Integer> q=new LinkedList<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(id[i]==0){
                q.add(i);
                int clr=colors.charAt(i)-'a';
                dp[i][clr]=1;
                 ans=Math.max(ans,1);
            }
        }

        int cnt=0;
        
        while(!q.isEmpty()){
            int u=q.poll();
            cnt++;
            for(int v:g[u]){
                int clr=colors.charAt(v)-'a';
                for(int c=0;c<26;c++){
                    dp[v][c]=Math.max(dp[v][c],dp[u][c]+(c==clr?1:0));
                    ans = Math.max(ans, dp[v][c]);
                }
                id[v]--;
                if (id[v]==0){
                    q.add(v);
                }
            }
        }
        if(cnt!=n){
            return -1;
        }
        return ans;
    }
}