#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    // Helper function to calculate distances from a starting node
    void getDistances(int startNode, const vector<int>& edges, vector<int>& dist) {
        int curr = startNode;
        int d = 0;
        
        // Traverse as long as the node is valid and hasn't been visited yet
        while (curr != -1 && dist[curr] == -1) {
            dist[curr] = d++;
            curr = edges[curr];
        }
    }

    int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        int n = edges.size();
        
        // Arrays to store shortest distances from node1 and node2. 
        // Initialized to -1 to represent unreached nodes.
        vector<int> dist1(n, -1);
        vector<int> dist2(n, -1);

        // Populate the distance arrays
        getDistances(node1, edges, dist1);
        getDistances(node2, edges, dist2);

        int minDist = INT_MAX;
        int ans = -1;

        // Find the node with the minimum of the maximum distances
        for (int i = 0; i < n; ++i) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int currentMax = max(dist1[i], dist2[i]);
                
                // If strictly less, update. 
                // Since we iterate from 0 to n-1, this naturally satisfies 
                // the "return the node with the smallest index" tie-breaker rule.
                if (currentMax < minDist) {
                    minDist = currentMax;
                    ans = i;
                }
            }
        }

        return ans;
    }
};