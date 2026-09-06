#include <vector>
#include <string>
#include <queue>
#include <algorithm>

using namespace std;

class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        int n = colors.length();
        vector<vector<int>> adj(n);
        vector<int> indegree(n, 0);
        
        // Build the graph and in-degrees
        for (const auto& edge : edges) {
            adj[edge[0]].push_back(edge[1]);
            indegree[edge[1]]++;
        }
        
        // dp[i][c] stores the max count of color c on any path ending at node i
        vector<vector<int>> dp(n, vector<int>(26, 0));
        queue<int> q;
        
        // Push all nodes with 0 in-degree and initialize their own color
        for (int i = 0; i < n; ++i) {
            if (indegree[i] == 0) {
                q.push(i);
                dp[i][colors[i] - 'a'] = 1;
            }
        }
        
        int max_color_value = 0;
        int visited_nodes = 0;
        
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            visited_nodes++;
            
            // Check the maximum color count for the current node
            for (int c = 0; c < 26; ++c) {
                max_color_value = max(max_color_value, dp[u][c]);
            }
            
            // Propagate paths to neighbors
            for (int v : adj[u]) {
                for (int c = 0; c < 26; ++c) {
                    int color_match = (colors[v] - 'a' == c) ? 1 : 0;
                    dp[v][c] = max(dp[v][c], dp[u][c] + color_match);
                }
                
                // If in-degree hits 0, all paths leading to v are processed
                if (--indegree[v] == 0) {
                    q.push(v);
                }
            }
        }
        
        // If we didn't visit all nodes, there is a cycle
        return visited_nodes == n ? max_color_value : -1;
    }
};