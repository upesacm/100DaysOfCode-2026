#include <vector>
#include <functional>

using namespace std;

class Solution {
public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        int n = prevRoom.size();
        vector<vector<int>> adj(n);
        
        // Build the tree (ignoring the root's parent which is -1)
        for (int i = 1; i < n; i++) {
            adj[prevRoom[i]].push_back(i);
        }
        
        vector<int> sz(n, 0);
        
        // DFS to calculate the size of each subtree
        function<int(int)> dfs = [&](int u) {
            sz[u] = 1;
            for (int v : adj[u]) {
                sz[u] += dfs(v);
            }
            return sz[u];
        };
        dfs(0);
        
        long long MOD = 1e9 + 7;
        
        // Helper function for modular exponentiation
        auto power = [&](long long base, long long exp) {
            long long res = 1;
            base %= MOD;
            while (exp > 0) {
                if (exp % 2 == 1) res = (res * base) % MOD;
                base = (base * base) % MOD;
                exp /= 2;
            }
            return res;
        };
        
        long long ans = 1;
        
        // Calculate N! % MOD
        for (int i = 1; i <= n; i++) {
            ans = (ans * i) % MOD;
        }
        
        // Divide by the product of all subtree sizes using modular inverse
        for (int i = 0; i < n; i++) {
            ans = (ans * power(sz[i], MOD - 2)) % MOD;
        }
        
        return ans;
    }
};