#include <iostream>
#include <vector>

using namespace std;

int findSilentLeader(int n, const vector<vector<int>>& trust) {
    vector<int> trustScores(n + 1, 0);
    
    for (const auto& relation : trust) {
        trustScores[relation[0]]--;
        trustScores[relation[1]]++;
    }
    
    for (int i = 1; i <= n; ++i) {
        if (trustScores[i] == n - 1) {
            return i;
        }
    }
    
    return -1;
}

int main() {
    int n = 5;
    // Trust relationships based on the provided example
    vector<vector<int>> trust = {{1, 3}, {2, 3}, {4, 3}, {5, 3}, {1, 2}};
    
    cout << "Output: " << findSilentLeader(n, trust) << "\n";
    // Expected Output: 3
    
    return 0;
}