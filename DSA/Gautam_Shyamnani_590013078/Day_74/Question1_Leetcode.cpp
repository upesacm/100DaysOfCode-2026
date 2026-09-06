class Solution {
public:
    void dfs(int u,vector<vector<int>> &adj,vector<bool>& visited,long long &size){
        visited[u] = true;
        size++;
        for(int &v : adj[u]){
            if(!visited[v]){
                dfs(v,adj,visited,size);
            }
        }
    }
    long long countPairs(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        for(auto &vec : edges){
            int u = vec[0];
            int v = vec[1];

            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<bool> visited(n,false);
        long long remainingNode = n;
        long long result = 0;

        for(int i = 0 ;i < n;i++){
            if(!visited[i]){
                long long size = 0;
                dfs(i,adj,visited,size);
                result += size * (remainingNode - size);
                remainingNode -= size;
            }
        }
        return result;
    }
};