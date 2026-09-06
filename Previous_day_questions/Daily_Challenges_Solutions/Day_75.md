<h2 align="center">Week 11 Day 75 (28/08/2026)</h2>

## 1. Largest Color Value in a Directed Graph (LeetCode #1857)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int largestPathValue(string colors, vector<vector<int>>& edges) {
    int n = colors.size();
    vector<vector<int>> adj(n);
    vector<int> indegree(n, 0);
    for (auto& e : edges) {
        adj[e[0]].push_back(e[1]);
        indegree[e[1]]++;
    }

    vector<array<int, 26>> count(n);
    for (auto& row : count) row.fill(0);

    queue<int> q;
    for (int i = 0; i < n; i++) if (indegree[i] == 0) q.push(i);

    int visited = 0, ans = 0;
    while (!q.empty()) {
        int u = q.front(); q.pop();
        visited++;

        int c = colors[u] - 'a';
        count[u][c]++;
        ans = max(ans, count[u][c]);

        for (int v : adj[u]) {
            for (int k = 0; k < 26; k++)
                count[v][k] = max(count[v][k], count[u][k]);
            if (--indegree[v] == 0) q.push(v);
        }
    }

    return visited == n ? ans : -1;
}

int main() {
    string colors;
    cin >> colors;
    int m;
    cin >> m;
    vector<vector<int>> edges(m, vector<int>(2));
    for (int i = 0; i < m; i++) cin >> edges[i][0] >> edges[i][1];
    cout << largestPathValue(colors, edges) << "\n";
    return 0;
}
```
* Time: O((n + m) * 26) — Kahn's algorithm visits every node once and every edge once, and at each edge relaxation the 26-length color-count array of the predecessor is merged into the successor's array in O(26), so the total work is proportional to (n + m) scaled by the constant alphabet size.
* Space: O(n * 26 + n + m) — for the `count` table (one length-26 array per node), the adjacency list, and the indegree array.

Because the color value of a path only depends on how many times each letter occurs along it, `count[u][c]` is defined as the maximum number of occurrences of color `c` over any path that ends at node `u`. Processing nodes strictly in topological order (via Kahn's BFS) guarantees that by the time a node `u` is popped, every predecessor of `u` has already finalized its `count` array, so `u`'s own count for its color can be safely incremented and then pushed forward to each successor `v` by taking an element-wise maximum. If the queue empties before all `n` nodes have been visited, some nodes never reached indegree zero, meaning a cycle exists and no valid (finite) path value can be defined, so the function returns `-1`; otherwise the answer is the largest single count value ever recorded across all nodes and colors.

---

## 2. Minimum Cost to Make a Ring Strongly Connected
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;

    // adj[u] holds the (at most 2) roads touching u, each stored as
    // {neighbor, sign, cost} where sign = +1 if the road is given as u->v,
    // and sign = -1 if the road is given as v->u.
    vector<vector<array<int, 3>>> adj(n + 1);
    long long totalCost = 0;

    for (int i = 0; i < n; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        adj[a].push_back({b, 1, c});
        adj[b].push_back({a, -1, c});
        totalCost += c;
    }

    int cur = 1, prev = -1;
    long long costClockwise = 0; // cost to orient every road along the traversal 1 -> ... -> 1

    for (int step = 0; step < n; step++) {
        for (auto& road : adj[cur]) {
            int v = road[0], sign = road[1], cost = road[2];
            if (v == prev) continue;
            if (sign == -1) costClockwise += cost; // road currently points against the traversal
            prev = cur;
            cur = v;
            break;
        }
    }

    cout << min(costClockwise, totalCost - costClockwise) << "\n";
    return 0;
}
```
* Time: O(n) — the ring has exactly `n` nodes and `n` roads, so building the adjacency lists is O(n), and the single walk around the ring visits each node and each road exactly once.
* Space: O(n) for the adjacency lists (two entries per road) and the ring traversal.

Since the underlying map is a ring, every node has degree exactly 2, and strong connectivity can only be achieved by orienting all `n` roads consistently as one directed cycle — either entirely clockwise or entirely counter-clockwise around the ring; any mixed orientation strands at least one city with no way in or out. The code walks the ring once starting from city `1`, always stepping to the neighbor that isn't the one just visited, and for each road checks whether its given direction already agrees with the clockwise traversal; if it points the other way, its reversal cost is added to `costClockwise`. Because every road is either aligned with the clockwise orientation or the counter-clockwise one, the cost of orienting the whole ring counter-clockwise is simply `totalCost - costClockwise`, so the answer is the cheaper of these two mutually exclusive global orientations.
