#include <vector>

using namespace std;

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        // Track the net trust score for each person (1-indexed)
        vector<int> trustScores(n + 1, 0);
        
        for (const auto& relation : trust) {
            trustScores[relation[0]]--; // Person trusts someone
            trustScores[relation[1]]++; // Person is trusted
        }
        
        // The judge will have a score of exactly n - 1
        for (int i = 1; i <= n; ++i) {
            if (trustScores[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
};