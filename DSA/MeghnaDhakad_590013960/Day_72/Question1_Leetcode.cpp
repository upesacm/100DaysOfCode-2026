#include <vector>

class Solution {
public:
    int findCenter(std::vector<std::vector<int>>& edges) {
        // Get the nodes from the first two edges
        int u1 = edges[0][0];
        int v1 = edges[0][1];
        
        int u2 = edges[1][0];
        int v2 = edges[1][1];
        
        // The center node must be the one that appears in both edges
        if (u1 == u2 || u1 == v2) {
            return u1;
        }
        
        return v1;
    }
};