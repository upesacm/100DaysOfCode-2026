#include <vector>

using namespace std;

class Solution {
public:
    long long countPairs(int n, vector<vector<int>>& edges) {
        // Build the adjacency list
        vector<vector<int>> adj(n);
        for (const auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }
        
        vector<bool> visited(n, false);
        long long unreachablePairs = 0;
        long long nodesProcessed = 0;
        
        // Traverse all nodes to find connected components
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                long long currentComponentSize = 0;
                dfs(i, adj, visited, currentComponentSize);
                
                // Calculate unreachable pairs using the running total of processed nodes
                unreachablePairs += currentComponentSize * nodesProcessed;
                nodesProcessed += currentComponentSize;
            }
        }
        
        return unreachablePairs;
    }
    
private:
    void dfs(int node, const vector<vector<int>>& adj, vector<bool>& visited, long long& count) {
        visited[node] = true;
        count++;
        
        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, count);
            }
        }
    }
};