<h2 align="center">Week 11 Day 4 (27/08/2026)</h2>

## 1. Count Unreachable Pairs of Nodes in an Undirected Graph (LeetCode #2316)
A problem that teaches connected-component analysis techniques by counting node pairs that lie in different components of an undirected graph. You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there is an undirected edge connecting nodes ai and bi. Return the number of pairs of different nodes that are unreachable from each other.

This problem is commonly asked in interviews and helps build concepts like:
- Union-Find (Disjoint Set Union)
- Connected components
- Combinatorial counting

which are important for solving reachability and component-based counting problems.

**Your task:** Find the total number of pairs of nodes that cannot reach each other through any sequence of edges.

### Input
An integer `n` representing the number of nodes in the graph. A 2D integer array `edges` representing the undirected edges of the graph.

**Constraints:**
- `1 <= n <= 10^5`
- `0 <= edges.length <= 2 * 10^5`
- `edges[i].length == 2`
- `0 <= ai, bi < n`
- `ai != bi`
- There are no repeated edges.

### Output
Return the number of pairs of different nodes that are unreachable from each other.

### Examples

**Input:**
```
n = 3
edges = [[0,1],[0,2],[1,2]]
```
**Output:**
```
0
```

---

**Input:**
```
n = 7
edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
```
**Output:**
```
14
```

---

## 2. Crab Chaos
A crab is an undirected graph consisting of one head and up to T feet. The head is connected directly to each of its feet. Given an undirected graph, find some vertex-disjoint subgraphs where each one is a crab. The goal is to maximize the total number of vertices covered by these crabs.

This problem is commonly asked in interviews and helps build concepts like:
- Graph matching
- Greedy vertex selection
- Star/subgraph packing

which are important for solving vertex-disjoint subgraph packing and coverage-maximization problems.

**Your task:** Find the maximum number of vertices that can be covered by vertex-disjoint crab subgraphs.

### Input
The first line contains an integer `C`, the number of test cases. For each test case, the first line contains three integers `N`, `T`, and `M`, representing the number of vertices, maximum number of feet, and number of edges respectively. The next M lines contain two integers `v1` and `v2`, representing an undirected edge between two vertices.

**Constraints:**
- `1 <= C <= 10`
- `2 <= T <= 100`
- `2 <= N <= 100`
- `0 <= M <= N(N - 1) / 2`
- `1 <= v1, v2 <= N`

### Output
For each test case, output the maximum number of vertices that can be covered by vertex-disjoint crabs.

### Examples

**Input:**
```
1
3 2 2
1 2
1 3
```
**Output:**
```
3
```

---

**Input:**
```
1
4 1 2
1 2
3 4
```
**Output:**
```
4
```

---
