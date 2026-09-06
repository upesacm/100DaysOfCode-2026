class Solution {
    long ans=0;
    Map<Integer,List<Integer>> m=new HashMap<>();
    Set<Integer> vis=new HashSet<>();
    private void dfs(int curri){
        vis.add(curri);
        ans++;
        List<Integer> n=m.get(curri);
        for(int i=0;i<n.size();i++){
            if(vis.contains(n.get(i))){
                continue;
            }
            dfs(n.get(i));
        }
    }
    private void constructadj(int n,int[][] e){
        for(int i=0;i<n;i++){
            m.put(i,new ArrayList<>());
        }
        for(int [] ed:e){
            int s1=ed[0];
            int s2=ed[1];
            List<Integer> l=m.get(s1);
            l.add(s2);
            m.put(s1,l);
            l=m.get(s2);
            l.add(s1);
            m.put(s2,l);
        }
    }

    public long countPairs(int n, int[][] edges) {
        constructadj(n,edges);
        long tp=0;
        for(int i=0;i<n;i++){
            if(!vis.contains(i)){
                ans=0;
                dfs(i);
                tp+=ans*(n-ans);
                n-=ans;
            }
        }
        return tp;
    }
}