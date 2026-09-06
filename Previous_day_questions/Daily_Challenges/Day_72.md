<h2 align="center">Week 11 Day 72 (25/08/2026)</h2>

## 1. Find Closest Node to Given Two Nodes (LeetCode #2359)

https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/

A problem that teaches distance computation on a functional graph — where every node has at most one outgoing edge — and finding a node that minimizes the worse of two distances. You are given a directed graph of `n` nodes numbered from `0` to `n - 1`, where each node has at most one outgoing edge. The graph is represented with a given 0-indexed array `edges` of size `n`, indicating that there is a directed edge from node `i` to node `edges[i]`. If there is no outgoing edge from `i`, then `edges[i] == -1`. You are also given two integers `node1` and `node2`. Note that edges may contain cycles.

This problem is commonly asked in interviews and helps build concepts like:
- BFS/traversal on functional graphs (at most one outgoing edge per node)
- Computing shortest distances from a single source along a deterministic path
- Minimizing the maximum of two quantities while breaking ties by smallest index

which are important for solving problems involving reachability and distance comparison in restricted graph structures.

**Your task:** Return the index of the node that can be reached from both `node1` and `node2`, such that the maximum between the distance from `node1` to that node, and from `node2` to that node, is minimized. If there are multiple answers, return the node with the smallest index, and if no possible answer exists, return -1.

### Input
An integer array `edges`, and two integers `node1` and `node2`, as described above.

**Constraints:**
- `n == edges.length`
- `1 <= n <= 10^5`
- `-1 <= edges[i] < n`
- `0 <= node1, node2 < n`

### Output
Return the index of the node reachable from both `node1` and `node2` that minimizes the maximum of the two distances, or -1 if no such node exists.

### Examples

**Input:**
```
edges = [2,2,3,-1], node1 = 0, node2 = 1
```
**Output:**
```
2
```

---

**Input:**
```
edges = [1,2,-1], node1 = 0, node2 = 2
```
**Output:**
```
2
```

---

## 2. Detective Aditya's Chase

A problem that teaches BFS on the complement graph, finding shortest paths in the graph formed by nonedges. Related topics: Graph Traversal, BFS, Complement Graph, Sparse Graphs.

Detective Aditya is investigating a homicide and he wants to chase down the murderer. The murderer knows he would definitely get caught if he takes the main roads for fleeing, so he uses the village roads (side lanes) for running away from the crime scene. Aditya observes the city map, but it doesn't show the village roads on it and shows only the main roads. The map of the city is a graph consisting of `N` nodes (labeled 1 to N) where a specific given node `S` represents the current position of Aditya and the rest of the nodes denote other places in the city, and an edge between two nodes is a main road between two places in the city. It can be suitably assumed that an edge that doesn't exist/isn't shown on the map is a village road (side lane). That means, there is a village road between two nodes `u` and `v` if and only if there is no city road between them. In this problem, distance is calculated as the number of village roads (side lanes) between any two places in the city.

This problem is commonly asked in interviews and helps build concepts like:
- BFS on an implicit complement graph without materializing it
- Maintaining an "unvisited" set for efficient traversal on dense/sparse complements
- Shortest path computation under sparse-graph constraints

which are important for solving problems involving implicit graphs where the edge set is defined by absence rather than presence.

**Your task:** Calculate the shortest distance from Aditya's position (Node `S`) to all other places in the city if he travels only using the village roads (side lanes).

**Note:** the graph/map of the city is ensured to be a sparse graph.

### Input
The first line contains `T`, denoting the number of test cases. `T` test cases follow. The first line of each test case has two integers `N` and `M`, denoting the number of cities in the map and the number of roads in the map. The next `M` lines each consist of two space-separated integers `u` and `v` denoting a main road between city `u` and city `v`. The last line has an integer `S`, denoting the current position of Aditya.

**Constraints:**
- `1 <= T <= 10`
- `1 <= N <= 10^5`
- `1 <= M <= N`
- Sum of `N` over all test cases `<= 10^5`

### Output
For each of the `T` test cases, print a single line consisting of `N-1` space-separated integers, denoting the shortest distances of the remaining `N-1` places from Aditya's position using the village roads, in ascending order based on vertex number.

### Examples

**Input:**
```
N = 4, M = 3, edges = (1,2) (2,3) (1,4), S = 1
```
**Output:**
```
3 1 2
```

---

**Input:**
```
N = 4, M = 2, edges = (1,2) (2,3), S = 2
```
**Output:**
```
2 2 1
```
