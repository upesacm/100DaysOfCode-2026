#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// DFS helper to traverse the cluster and count its size
void dfs(int node, const vector<vector<int>>& adj, vector<bool>& visited, int& currentSize) {
    visited[node] = true;
    currentSize++;
    
    for (int neighbor : adj[node]) {
        if (!visited[neighbor]) {
            dfs(neighbor, adj, visited, currentSize);
        }
    }
}

// Returns a pair: {number of wells needed, size of largest cluster}
pair<int, int> solveVillageWells(int N, int M, const vector<pair<int, int>>& edges) {
    // 1-indexed adjacency list
    vector<vector<int>> adj(N + 1);
    for (const auto& edge : edges) {
        adj[edge.first].push_back(edge.second);
        adj[edge.second].push_back(edge.first);
    }

    vector<bool> visited(N + 1, false);
    int clusterCount = 0;
    int maxClusterSize = 0;

    // Explore all villages
    for (int i = 1; i <= N; ++i) {
        if (!visited[i]) {
            clusterCount++; // Found a new unconnected cluster
            int currentSize = 0;
            
            // Traverse the entire cluster
            dfs(i, adj, visited, currentSize);
            
            // Track the largest cluster size
            maxClusterSize = max(maxClusterSize, currentSize);
        }
    }

    return {clusterCount, maxClusterSize};
}

int main() {
    int N = 5, M = 3;
    vector<pair<int, int>> edges = {{1, 2}, {2, 3}, {4, 5}};
    
    pair<int, int> result = solveVillageWells(N, M, edges);
    
    cout << "Output: " << result.first << " " << result.second << "\n";
    // Expected Output: 2 3 (2 separate clusters, largest has size 3: {1,2,3})
    
    return 0;
}