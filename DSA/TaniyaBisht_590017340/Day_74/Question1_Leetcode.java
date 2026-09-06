
class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long remNodes = n;
        long unreachPairs =0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
            long elemInComponent = dfs(adj, visited, i);
            remNodes -= elemInComponent;
            unreachPairs += (elemInComponent * remNodes);
        }
    }
    return unreachPairs;
    }
    long dfs( List<List<Integer>> adj, boolean[] visited, int src){
        if(visited[src]){
            return 0;
        }
        visited[src] = true;
        int elements = 1;
        for(int nbr:adj.get(src)){
            elements += dfs(adj, visited, nbr);
        }
        return elements;
    }
}