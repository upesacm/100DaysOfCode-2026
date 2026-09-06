<h2 align="center">Week 11 Day 73 (26/08/2026)</h2>

## 1. Find Closest Node to Given Two Nodes (LeetCode #2359)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

vector<int> bfsDist(int start, vector<int>& edges) {
    int n = edges.size();
    vector<int> dist(n, -1);
    dist[start] = 0;
    int cur = start;
    while (edges[cur] != -1 && dist[edges[cur]] == -1) {
        dist[edges[cur]] = dist[cur] + 1;
        cur = edges[cur];
    }
    return dist;
}

int closestMeetingNode(vector<int>& edges, int node1, int node2) {
    vector<int> dist1 = bfsDist(node1, edges);
    vector<int> dist2 = bfsDist(node2, edges);

    int n = edges.size();
    int best = -1, bestDist = INT_MAX;
    for (int i = 0; i < n; i++) {
        if (dist1[i] == -1 || dist2[i] == -1) continue;
        int d = max(dist1[i], dist2[i]);
        if (d < bestDist) {
            bestDist = d;
            best = i;
        }
    }
    return best;
}

int main() {
    int n;
    cin >> n;
    vector<int> edges(n);
    for (int i = 0; i < n; i++) cin >> edges[i];
    int node1, node2;
    cin >> node1 >> node2;
    cout << closestMeetingNode(edges, node1, node2) << "\n";
    return 0;
}
```
* Time: O(n) — since every node has at most one outgoing edge, following the chain from `node1` (or `node2`) visits each node at most once before either hitting `-1` or looping back onto an already-visited node, so each single-source distance array takes O(n) to build, and combining them is another O(n) pass.
* Space: O(n) for the two distance arrays.

Because every node has out-degree at most 1, the graph reachable from a single source is a simple path that may end in a cycle, so following `edges[cur]` while marking distances stops as soon as it hits a node whose distance is already known — this correctly handles cycles without ever revisiting a node. Running this chain-walk once from `node1` and once from `node2` gives two distance arrays where `dist[i] == -1` marks unreachable nodes. A node is a valid "meeting point" only if it appears in both arrays, and among all such nodes the answer minimizes the larger of the two distances, breaking ties by scanning indices in increasing order so the first minimum encountered is naturally the smallest index.

---

## 2. Detective Aditya's Chase
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

vector<int> complementBFS(int n, int s, vector<unordered_set<int>>& adj) {
    vector<int> dist(n + 1, -1);
    dist[s] = 0;

    set<int> unvisited;
    for (int i = 1; i <= n; i++) if (i != s) unvisited.insert(i);

    queue<int> q;
    q.push(s);

    while (!q.empty()) {
        int u = q.front(); q.pop();

        vector<int> toRemove;
        for (int v : unvisited) {
            if (adj[u].find(v) == adj[u].end()) {
                dist[v] = dist[u] + 1;
                toRemove.push_back(v);
                q.push(v);
            }
        }
        for (int v : toRemove) unvisited.erase(v);
    }
    return dist;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<unordered_set<int>> adj(n + 1);
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].insert(v);
        adj[v].insert(u);
    }
    int s;
    cin >> s;

    vector<int> dist = complementBFS(n, s, adj);

    bool first = true;
    for (int i = 1; i <= n; i++) {
        if (i == s) continue;
        if (!first) cout << " ";
        cout << dist[i];
        first = false;
    }
    cout << "\n";
    return 0;
}
```
* Time: O((N + M) log N) — the algorithm never scans an already-visited node twice because visited nodes are removed from the `unvisited` set, so across the whole BFS the total work of iterating over `unvisited` and checking each candidate against `adj[u]` is bounded by O(N) set iterations plus O(M) adjacency lookups, with an extra `log N` factor from insertions/erasures in the ordered set.
* Space: O(N + M) for the adjacency sets, the unvisited set, and the distance array.

Since the village-road graph is the complement of a sparse main-road graph, explicitly building it would need up to O(N^2) edges, so instead the BFS is run directly on the complement: for the current node `u`, every node still in `unvisited` that is *not* one of `u`'s main-road neighbors is reachable by one village road, gets its distance set, is pushed to the queue, and is removed from `unvisited` so it is never reconsidered. Because each node is removed from `unvisited` exactly once, and each removal is only ever "blocked" by checking membership in the sparse adjacency set `adj[u]`, the overall traversal cost stays close to O(N + M) rather than the O(N^2) a naive complement-graph BFS would require, which is essential given the problem's guarantee that the graph is sparse.
