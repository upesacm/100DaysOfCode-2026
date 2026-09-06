#include <iostream>
#include <vector>
#include <queue>

using namespace std;

bool hasEulerTrail(int n, vector<pair<int, int>> edges, int k) {
    int current_nodes = n;
    
    // Step 1: Simulate building the Line Graph k times
    for (int step = 0; step < k; step++) {
        if (edges.empty()) break;
        
        // Group incident edges by their vertex endpoints
        vector<vector<int>> adj(current_nodes + 1);
        for (int i = 0; i < edges.size(); i++) {
            adj[edges[i].first].push_back(i);
            adj[edges[i].second].push_back(i);
        }
        
        vector<pair<int, int>> next_edges;
        
        // Edges sharing a vertex become connected in the line graph
        for (int i = 0; i <= current_nodes; i++) {
            for (size_t u = 0; u < adj[i].size(); u++) {
                for (size_t v = u + 1; v < adj[i].size(); v++) {
                    next_edges.push_back({adj[i][u], adj[i][v]});
                }
            }
        }
        
        // The new vertices are exactly the edges of the previous graph
        current_nodes = edges.size(); 
        edges = next_edges;
    }
    
    // An empty graph trivially satisfies the condition
    if (edges.empty()) return true; 
    
    // Step 2: Validate Euler Trail properties
    vector<int> deg(current_nodes, 0);
    vector<vector<int>> final_adj(current_nodes);
    
    for (auto e : edges) {
        deg[e.first]++;
        deg[e.second]++;
        final_adj[e.first].push_back(e.second);
        final_adj[e.second].push_back(e.first);
    }
    
    int odd_count = 0;
    int start_node = -1;
    for (int i = 0; i < current_nodes; i++) {
        if (deg[i] % 2 != 0) odd_count++;
        if (deg[i] > 0) start_node = i;
    }
    
    // Must have exactly 0 or 2 odd-degree vertices
    if (odd_count != 0 && odd_count != 2) return false;
    
    // Verify connectivity among all edges using BFS
    if (start_node != -1) {
        vector<bool> visited(current_nodes, false);
        queue<int> q;
        
        q.push(start_node);
        visited[start_node] = true;
        
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            
            for (int v : final_adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                }
            }
        }
        
        // Ensure no disconnected components with active edges exist
        for (int i = 0; i < current_nodes; i++) {
            if (deg[i] > 0 && !visited[i]) return false;
        }
    }
    
    return true;
}

int main() {
    int n = 4;
    vector<pair<int, int>> edges = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
    int k = 1;
    
    cout << "Output: " << (hasEulerTrail(n, edges, k) ? "true" : "false") << "\n";
    // Expected Output: true
    
    return 0;
}
