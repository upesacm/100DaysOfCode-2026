<h2 align="center">Week 11 Day 76 (29/08/2026)</h2>

## 1. Count Ways to Build Rooms in an Ant Colony (LeetCode #1916)

A problem that teaches tree dynamic programming combined with combinatorics, and reasoning about how independent subtree construction orders can be interleaved while preserving parent-before-child constraints. You must build `n` rooms numbered from `0` to `n - 1`. Room `0` already exists. The array `prevRoom` gives, for each room `i`, which room must be built before it; this forms a rooted tree with room `0` as the root.

A room can only be built after its direct prerequisite room already exists. The task is to count the number of distinct valid orders in which all rooms can be built while satisfying these tree constraints.

This problem is commonly asked in interviews and helps build concepts like:
- Tree DP using DFS to compute subtree sizes and number of valid orders
- Modular combinatorics, factorials, and inverse factorials
- Counting valid interleavings of independent subtrees using binomial coefficients

which are important for solving problems that combine dependency trees with counting arrangements under precedence constraints.

**Your task:** Count the number of distinct valid orders in which all `n` rooms can be built, and return the answer modulo `10^9 + 7`.

### Input
An integer `n` and an array `prevRoom` of length `n`, where `prevRoom[i]` is the prerequisite room for room `i`, and `prevRoom[0] = -1`.

**Constraints:**
- `2 <= n <= 10^5`
- `prevRoom[0] == -1`
- `0 <= prevRoom[i] < n` for every `1 <= i < n`
- Every room is reachable from room `0`, so the prerequisites form a valid rooted tree

### Output
Return the number of valid build orders, modulo `10^9 + 7`.

### Examples

**Input:**
```
prevRoom = [-1,0,1]
```

**Output:**
```
1
```

---

**Input:**
```
prevRoom = [-1,0,0,1,2]
```

**Output:**
```
6
```

---

## 2. Does the k-th Line Graph Still Have an Euler Trail?

A problem that teaches reasoning about Euler trails, vertex degrees, and the effect of repeatedly applying the line-graph operation. You are given a simple, connected graph `G` that already has an Euler trail and is not itself a path graph.

The line graph `L(G)` is formed by turning every edge of `G` into a vertex. Two vertices in `L(G)` are connected exactly when their corresponding edges in `G` share an endpoint. This operation can be applied repeatedly:

`L^0(G) = G`

`L^k(G) = L(L^(k-1)(G))` for `k >= 1`.

This problem is commonly asked in interviews and helps build concepts like:
- Euler trail characterization through the number of odd-degree vertices
- Degree transformations in a line graph
- Reasoning about repeated graph operations without explicitly constructing huge graphs

which are important for solving problems where structural properties must be tracked across many transformations.

**Your task:** Determine whether `L^k(G)`, the graph obtained after applying the line-graph operation `k` times, still has an Euler trail.

### Input
An integer `n`, a list `edges` where each element is a pair `[u, v]` denoting an edge between vertices `u` and `v`, and an integer `k`, the number of times to apply the line-graph operation.

**Constraints:**
- `5 <= n <= 2 × 10^5`
- `n - 1 <= edges.length <= min(n(n - 1)/2, 2 × 10^5)`
- `1 <= k <= 2 × 10^5`
- `G` is simple and connected
- `G` has an Euler trail
- `G` is not itself a path graph

### Output
Return `true` if `L^k(G)` has an Euler trail; otherwise return `false`.

### Examples

**Input:**
```
n = 4
edges = [(1,2),(2,3),(3,4),(4,1)]
k = 1
```

**Output:**
```
true
```

---

**Input:**
```
n = 6
edges = [(1,2),(2,3),(3,1),(1,4),(4,5),(5,6),(6,4)]
k = 1
```

**Output:**
```
false
```

---
