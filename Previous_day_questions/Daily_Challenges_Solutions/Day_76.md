<h2 align="center">Week 11 Day 76 (29/08/2026)</h2>

## 1. Count Ways to Build Rooms in an Ant Colony (LeetCode #1916)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

class Solution {
    static constexpr long long MOD = 1000000007LL;

    vector<vector<int>> tree;
    vector<long long> fact, invFact;

    long long modPow(long long a, long long e) {
        long long ans = 1;
        while (e > 0) {
            if (e & 1) ans = ans * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return ans;
    }

    long long C(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    // Returns {subtree_size, number_of_valid_orders}
    pair<int, long long> dfs(int u) {
        int totalSize = 1;
        long long ways = 1;

        for (int v : tree[u]) {
            auto [childSize, childWays] = dfs(v);

            ways = ways * childWays % MOD;
            ways = ways * C(totalSize + childSize - 1, childSize) % MOD;

            totalSize += childSize;
        }

        return {totalSize, ways};
    }

public:
    int waysToBuildRooms(vector<int>& prevRoom) {
        int n = prevRoom.size();
        tree.assign(n, {});

        for (int i = 1; i < n; i++)
            tree[prevRoom[i]].push_back(i);

        fact.resize(n + 1);
        invFact.resize(n + 1);

        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = fact[i - 1] * i % MOD;

        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i >= 1; i--)
            invFact[i - 1] = invFact[i] * i % MOD;

        return (int)dfs(0).second;
    }
};
```

* Time: O(n) — building the rooted tree takes O(n), the DFS visits every room once, and factorial/inverse-factorial preprocessing also takes O(n).
* Space: O(n) — for the adjacency list, factorial arrays, and DFS recursion stack.

The prerequisite relation forms a rooted tree. For any room `u`, the parent `u` must be built before every room in its subtree, but after `u` has been built, the valid construction orders of different child subtrees can be interleaved arbitrarily as long as the internal order of each subtree is preserved. If the child subtrees processed so far contain `totalSize - 1` rooms and a new child subtree contains `childSize` rooms, the number of ways to interleave them is the binomial coefficient `C(totalSize + childSize - 1, childSize)`. Multiplying this by the number of valid orders inside the child subtree gives the total number of valid orders for `u`. The DFS returns both subtree size and number of valid orders, while factorials and modular inverse factorials allow every required binomial coefficient to be computed in O(1).

---

## 2. Does the k-th Line Graph Still Have an Euler Trail?
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

bool hasEulerTrail(int n, const vector<pair<int, int>>& edges) {
    vector<int> degree(n + 1, 0);

    for (auto [u, v] : edges) {
        degree[u]++;
        degree[v]++;
    }

    int odd = 0;
    for (int i = 1; i <= n; i++)
        odd += (degree[i] & 1);

    return odd == 0 || odd == 2;
}

int main() {
    int n, m, k;
    cin >> n >> m >> k;

    vector<pair<int, int>> edges(m);
    for (auto& [u, v] : edges)
        cin >> u >> v;

    vector<pair<int, int>> curEdges = edges;
    int curN = n;

    for (int step = 0; step < k; step++) {
        vector<vector<int>> incident(curN + 1);

        for (int i = 0; i < (int)curEdges.size(); i++) {
            auto [u, v] = curEdges[i];
            incident[u].push_back(i);
            incident[v].push_back(i);
        }

        vector<pair<int, int>> nextEdges;

        for (int u = 1; u <= curN; u++) {
            auto& list = incident[u];
            for (int i = 0; i < (int)list.size(); i++) {
                for (int j = i + 1; j < (int)list.size(); j++) {
                    nextEdges.push_back({list[i] + 1, list[j] + 1});
                }
            }
        }

        curN = curEdges.size();
        curEdges.swap(nextEdges);
    }

    cout << (hasEulerTrail(curN, curEdges) ? "true\n" : "false\n");
    return 0;
}
```

* Time: O(|V(L^k(G))| + |E(L^k(G))|) for the final Euler-trail check, but explicit construction across `k` line-graph transformations can grow rapidly and may become impractical for large `k`.
* Space: O(|V(L^k(G))| + |E(L^k(G))|) when explicitly storing the iterated line graph.

An undirected connected graph has an Euler trail exactly when it has `0` or `2` vertices of odd degree. Therefore, after constructing the required iterated line graph, the final check is simply a degree-parity test. In a line graph, each edge of the current graph becomes a vertex, and two such vertices are adjacent when the corresponding edges share an endpoint. The solution above follows this definition directly and is easy to understand for small graphs and small values of `k`. However, because repeated line-graph construction can become very large, this direct simulation is not suitable for the maximum constraints; an optimized solution for the full limits should exploit degree-parity and structural properties of the original graph to avoid constructing every intermediate line graph.

---
