<h2 align="center">Week 11 Day 72 (25/08/2026) — Solutions (C)</h2>

## 1. Find Closest Node to Given Two Nodes (LeetCode #2359)

### Approach
Since every node has at most one outgoing edge, the graph is a **functional graph** — starting from any node, following `edges[]` traces out a single deterministic path that either ends at a node with no outgoing edge (`-1`) or enters a cycle. So a simple BFS/walk from `node1` and from `node2` gives the distance to every reachable node in O(n) each. Then for every node reachable from both, take `max(dist1, dist2)`, and pick the node with the smallest such max (breaking ties by smallest index, which falls out naturally if we scan indices in order).

### Complexity
- Time: `O(n)`
- Space: `O(n)`

```c
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int closestMeetingNode(int *edges, int n, int node1, int node2) {
    int *dist1 = malloc(sizeof(int) * n);
    int *dist2 = malloc(sizeof(int) * n);

    for (int i = 0; i < n; i++) {
        dist1[i] = -1;
        dist2[i] = -1;
    }

    // Walk from node1
    int cur = node1, d = 0;
    while (cur != -1 && dist1[cur] == -1) {
        dist1[cur] = d++;
        cur = edges[cur];
    }

    // Walk from node2
    cur = node2, d = 0;
    while (cur != -1 && dist2[cur] == -1) {
        dist2[cur] = d++;
        cur = edges[cur];
    }

    int best = -1;
    long long bestMax = LLONG_MAX;

    for (int i = 0; i < n; i++) {
        if (dist1[i] == -1 || dist2[i] == -1) continue;
        long long m = dist1[i] > dist2[i] ? dist1[i] : dist2[i];
        if (m < bestMax) {
            bestMax = m;
            best = i;
        }
    }

    free(dist1);
    free(dist2);
    return best;
}

int main(void) {
    int edges[] = {2, 2, 3, -1};
    int n = 4;
    printf("%d\n", closestMeetingNode(edges, n, 0, 1)); // 2

    int edges2[] = {1, 2, -1};
    printf("%d\n", closestMeetingNode(edges2, 3, 0, 2)); // 2

    return 0;
}
```

### Why it works
- A node's own outgoing edge only ever points to *one* place, so the "walk" from a source never branches — it's either a simple path, or a path that loops into a cycle. The `while (dist[cur] == -1)` guard stops us the moment we'd revisit a node, so we never spin forever on a cycle.
- Scanning `i` from `0` upward and only updating `best` on a strictly smaller max automatically keeps the smallest index on ties.

---

## 2. Detective Aditya's Chase

### Approach
We need shortest paths in the **complement graph** (village roads = pairs with no main road), but building that graph explicitly can have up to `O(N^2)` edges — too slow. The standard trick for "BFS on a complement graph" is to keep a set of **still-unvisited** vertices (as a doubly linked list / balanced BST), and during BFS from a node `u`, instead of iterating over `u`'s complement-neighbors, iterate over the **unvisited set** and remove the ones that *are* real neighbors of `u` (skip them), treating everything else remaining as reachable in one village-road step. Because the graph is sparse (`M <= N`), each vertex has few real edges, so each BFS step is cheap and every vertex is removed from the "unvisited" set exactly once — giving `O((N + M) log N)` overall.

Steps:
1. Read the main-road edges into adjacency lists (as hash sets for O(1) "is this a main road" checks).
2. Maintain an unvisited doubly linked list over `1..N`.
3. BFS from `S`: pop `S` from unvisited. For each vertex `u` popped from the queue, walk the unvisited list; for each candidate `v`, if `(u, v)` is **not** a main road, it's a village road — remove `v` from unvisited, set `dist[v] = dist[u] + 1`, push it to the queue. If `(u, v)` **is** a main road, just skip over it (leave it in the list, it might get visited via someone else).
4. Print distances for all nodes except `S`, in ascending vertex order.

### Complexity
- Time: `O((N + M) log N)` per test case (hash set lookups), well within `10^5` sum-of-N limits.
- Space: `O(N + M)`

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAXN 100005

int N, M, S;
int dist_[MAXN];

// doubly linked list over unvisited vertices (1..N), 0 = head sentinel
int nxt[MAXN + 1], prv[MAXN + 1];

// adjacency (main roads) stored as sorted arrays for binary search
int *adj[MAXN];
int adjLen[MAXN];
int edgeU[MAXN], edgeV[MAXN];

int cmp(const void *a, const void *b) {
    return *(int *)a - *(int *)b;
}

int isMainRoad(int u, int v) {
    int lo = 0, hi = adjLen[u] - 1;
    while (lo <= hi) {
        int mid = (lo + hi) / 2;
        if (adj[u][mid] == v) return 1;
        if (adj[u][mid] < v) lo = mid + 1;
        else hi = mid - 1;
    }
    return 0;
}

void unlinkNode(int v) {
    nxt[prv[v]] = nxt[v];
    prv[nxt[v]] = prv[v];
}

int queue_[MAXN], qHead, qTail;

void solve(void) {
    scanf("%d %d", &N, &M);

    int *deg = calloc(N + 1, sizeof(int));
    for (int i = 0; i < M; i++) {
        int u, v;
        scanf("%d %d", &u, &v);
        edgeU[i] = u; edgeV[i] = v;
        deg[u]++; deg[v]++;
    }
    for (int i = 1; i <= N; i++) {
        adj[i] = malloc(sizeof(int) * deg[i]);
        adjLen[i] = 0;
    }
    for (int i = 0; i < M; i++) {
        int u = edgeU[i], v = edgeV[i];
        adj[u][adjLen[u]++] = v;
        adj[v][adjLen[v]++] = u;
    }
    for (int i = 1; i <= N; i++) {
        qsort(adj[i], adjLen[i], sizeof(int), cmp);
    }
    free(deg);

    scanf("%d", &S);

    // build unvisited doubly linked list: 0 <-> 1 <-> 2 <-> ... <-> N <-> 0 (using N+1 as tail sentinel)
    for (int i = 1; i <= N; i++) {
        nxt[i] = i + 1;
        prv[i] = i - 1;
        dist_[i] = -1;
    }
    nxt[0] = 1;
    prv[N + 1] = N;
    nxt[N] = N + 1;
    prv[1] = 0;

    unlinkNode(S);
    dist_[S] = 0;
    qHead = qTail = 0;
    queue_[qTail++] = S;

    while (qHead < qTail) {
        int u = queue_[qHead++];
        int v = nxt[0]; // start scanning unvisited list from the head
        while (v != N + 1) {
            int nextV = nxt[v]; // save before possible unlink
            if (!isMainRoad(u, v)) {
                unlinkNode(v);
                dist_[v] = dist_[u] + 1;
                queue_[qTail++] = v;
            }
            v = nextV;
        }
    }

    // output distances for all nodes except S, ascending vertex order
    int first = 1;
    for (int i = 1; i <= N; i++) {
        if (i == S) continue;
        if (!first) printf(" ");
        printf("%d", dist_[i]);
        first = 0;
    }
    printf("\n");

    for (int i = 1; i <= N; i++) free(adj[i]);
}

int main(void) {
    int T;
    scanf("%d", &T);
    while (T--) {
        solve();
    }
    return 0;
}
```

### Notes
- `isMainRoad` uses binary search over sorted adjacency arrays (`O(log M)` per check) instead of a hash set, to keep the solution dependency-free in plain C; a hash set would work too and is asymptotically similar here since degrees are small (`M <= N`).
- Every vertex is unlinked from the unvisited list exactly once, so across the whole BFS the total work spent "walking past" main-road neighbors and skipping them is bounded by `O(M)` skips plus `O(N)` total removals — this is what keeps the algorithm efficient despite the complement graph being potentially dense.
- The problem guarantees the graph is **connected** in the complement sense implicitly (via `1 <= M <= N` sparsity), but if a node were unreachable, its `dist_` would remain `-1`; you may want to double check expected behavior for disconnected complements if the judge tests that case.

### Verifying against samples

**Sample 1:** `N=4, M=3, edges=(1,2)(2,3)(1,4), S=1`
Village roads (complement): (1,3), (2,4), (3,4).
BFS from 1: dist[3]=1 (direct village road). dist[2] and dist[4] are not directly reachable from 1 via village road (both are main roads), so found in second layer via 3: 3-2? (2,3) is a main road, not village. Via 3-4 (village road) → dist[4]=2. Then from 4: 4-2 (village road, since (2,4) not a main edge) → dist[2]=3.
Output order (vertex 2,3,4): `3 1 2` ✓.

**Sample 2:** `N=4, M=2, edges=(1,2)(2,3), S=2`
Village roads: (1,3),(1,4),(2,4),(3,4).
BFS from 2: dist[4]=1 (village road). dist[1]: (1,2) is main road, not reachable directly; via 4 → (1,4) is village road → dist[1]=2. dist[3]: (2,3) is main road; via 4 → (3,4) village road → dist[3]=2.
Output order (vertex 1,3,4): `2 2 1` ✓.
