<h2 align="center">Week 11 Day 74 (27/08/2026)</h2>

## 1. Count Unreachable Pairs of Nodes in an Undirected Graph (LeetCode #2316)

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

vector<int> parent, sz;

int find(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

void unite(int a, int b) {
    a = find(a); b = find(b);
    if (a == b) return;
    if (sz[a] < sz[b]) swap(a, b);
    parent[b] = a;
    sz[a] += sz[b];
}

long long countPairs(int n, vector<vector<int>>& edges) {
    parent.resize(n);
    sz.assign(n, 1);
    iota(parent.begin(), parent.end(), 0);

    for (auto& e : edges) unite(e[0], e[1]);

    long long remaining = n, ans = 0;
    for (int i = 0; i < n; i++) {
        if (find(i) == i) { // representative of a component
            ans += (long long) sz[i] * (remaining - sz[i]);
            remaining -= sz[i];
        }
    }
    return ans;
}

int main() {
    vector<vector<int>> e1 = {{0,1},{0,2},{1,2}};
    cout << countPairs(3, e1) << endl; // 0

    vector<vector<int>> e2 = {{0,2},{0,5},{2,4},{1,6},{5,4}};
    cout << countPairs(7, e2) << endl; // 14

    return 0;
}
```

How it works: a Union-Find (DSU) structure groups nodes into connected components. Two nodes are unreachable from each other exactly when they land in different components. Rather than computing `size_i * size_j` for every pair of components (which would need nested loops), a running total works in one pass: for each component processed, its size multiplied by the number of "remaining" nodes not yet accounted for gives exactly its contribution to cross-component pairs, and then that size is subtracted from `remaining` before moving to the next component.

Complexity: O(n + m · α(n)) time (α = inverse Ackermann, effectively constant), O(n) extra space.

---

## 2. Crab Chaos

### Solution

This is a **maximum star-forest packing** problem: pick vertex-disjoint "stars" (a head connected to 1–T of its neighbors as feet) to cover as many vertices as possible. The standard greedy for this works bottom-up on a DFS spanning tree of each component: a node becomes a head only if, after all its children have already been resolved, it still has at least one uncovered child left over to claim as a foot — otherwise it stays uncovered and becomes available to be claimed as a foot by its own parent instead.

```cpp
#include <bits/stdc++.h>
using namespace std;

int N, T;
vector<vector<int>> adj;
vector<bool> covered;
vector<bool> visited;

// Post-order DFS greedy: a node becomes a "head" if it has at least one
// still-uncovered child once its whole subtree has been processed, pairing
// with up to T of those children as its "feet". Otherwise it stays
// uncovered, available to become a foot for its own parent.
void dfs(int u, int parent) {
    visited[u] = true;
    vector<int> availableChildren;

    for (int v : adj[u]) {
        if (v == parent || visited[v]) continue;
        dfs(v, u);
        if (!covered[v]) availableChildren.push_back(v);
    }

    if (!availableChildren.empty()) {
        int k = min((int)availableChildren.size(), T);
        covered[u] = true;
        for (int i = 0; i < k; i++) covered[availableChildren[i]] = true;
    }
}

int main() {
    int C;
    cin >> C;
    while (C--) {
        int n, t, m;
        cin >> n >> t >> m;

        N = n; T = t;
        adj.assign(n + 1, {});
        covered.assign(n + 1, false);
        visited.assign(n + 1, false);

        for (int i = 0; i < m; i++) {
            int a, b;
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }

        for (int i = 1; i <= n; i++) if (!visited[i]) dfs(i, 0);

        int total = 0;
        for (int i = 1; i <= n; i++) if (covered[i]) total++;
        cout << total << "\n";
    }
    return 0;
}
```

How it works: each connected component is explored with a DFS. By the time a node's DFS call finishes, every descendant in its subtree has already decided whether it's covered. If any children are still uncovered, the current node "adopts" up to `T` of them as feet and becomes a head itself — covering itself plus those children. If it has no uncovered children available, it deliberately stays uncovered so its own parent has the option to adopt *it* as a foot later, which is what lets long chains still get mostly covered instead of wasting a head on a node with nothing left to pair with.

Complexity: O(N + M) time per test case, O(N + M) extra space.

**Sample walkthroughs:**
- Sample 1 (`N=3, T=2`, edges `1-2, 1-3`): node 1 finishes processing leaves 2 and 3 (both uncovered), adopts both as feet (T=2 allows it) → all 3 vertices covered.
- Sample 2 (`N=4, T=1`, edges `1-2, 3-4`): two separate components, each a single edge; with `T=1` each pair simply forms its own 2-vertex crab → all 4 vertices covered.
