#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        vector<int> degree(n + 1, 0);
        for (auto &t : trust) {
            int a = t[0];
            int b = t[1];

            degree[a]--;  
            degree[b]++;  
        }
        for (int i = 1; i <= n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
};

