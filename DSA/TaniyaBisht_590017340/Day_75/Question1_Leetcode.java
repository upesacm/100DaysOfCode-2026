
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];
        for(int[] e: edges){
            graph.computeIfAbsent(e[0], k-> new ArrayList<>()).add(e[1]);
            inDegree[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int[][] colorDp = new int[n][26];
        int visited =0, ans=1;
        while(!q.isEmpty()){
            int node = q.poll();
            int color = colors.charAt(node) - 'a';
            colorDp[node][color]++;
            visited++;
            ans = Math.max(ans, colorDp[node][color]);
            if(!graph.containsKey(node)){
                continue;
            }
            for(int nextNode:graph.get(node)){
                for(int i=0; i<26; i++){
                    colorDp[nextNode][i] = Math.max(colorDp[node][i], colorDp[nextNode][i]);
                }
                inDegree[nextNode]--;
                if(inDegree[nextNode]==0){
                    q.offer(nextNode);
                }
            }
        }
        return visited <n? -1 :  ans;
    }
}