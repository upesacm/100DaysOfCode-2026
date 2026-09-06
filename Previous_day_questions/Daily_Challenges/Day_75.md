<h2 align="center">Week 11 Day 75 (28/08/2026)</h2>

## 1. Largest Color Value in a Directed Graph (LeetCode #1857)

A problem that teaches topological sorting combined with dynamic programming, and reasoning about cycle detection while accumulating counts along paths. There is a directed graph of `n` colored nodes and `m` edges. The nodes are numbered from `0` to `n - 1`. You are given a string `colors` where `colors[i]` is a lowercase English letter representing the color of the `i`th node in this graph (0-indexed). You are also given a 2D array `edges` where `edges[j] = [aj, bj]` indicates that there is a directed edge from node `aj` to node `bj`.

A valid path in the graph is a sequence of nodes `x1 -> x2 -> x3 -> ... -> xk` such that there is a directed edge from `xi` to `xi+1` for every `1 <= i < k`. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

This problem is commonly asked in interviews and helps build concepts like:
- Kahn's algorithm for topological sorting
- DP over topological order, propagating state from predecessors to successors
- Detecting cycles in a directed graph as a side effect of topological sort

which are important for solving problems that combine path-based accumulation with the DAG structure of a graph.

**Your task:** Return the largest color value of any valid path in the given graph, or `-1` if the graph contains a cycle.

### Input
A string `colors` and a 2D array `edges`, as described above.

**Constraints:**
- `n == colors.length`
- `m == edges.length`
- `1 <= n <= 10^5`
- `0 <= m <= 10^5`
- `colors` consists of lowercase English letters.
- `0 <= aj, bj < n`

### Output
Return the largest color value of any valid path in the graph, or `-1` if the graph contains a cycle.

### Examples

**Input:**
```
colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
```
**Output:**
```
3
```

---

**Input:**
```
colors = "a", edges = [[0,0]]
```
**Output:**
```
-1
```

---

## 2. Minimum Cost to Make a Ring Strongly Connected

A problem that teaches reasoning about strong connectivity on a ring topology, and reducing a graph-orientation problem to a single linear scan. Related topics: Graph Traversal, Strongly Connected Components, Cycle Orientation, Greedy.

The government of India decided to introduce one-way traffic in all cities. Previously, all `n` cities of India were connected by `n` two-way roads in a ring, i.e., each city was connected directly to exactly two other cities, and from each city it was possible to get to any other city.

The government introduced one-way traffic on all `n` roads, but soon realized it's impossible to get from some cities to others. Now for each road, we know the direction of traffic and the cost of reversing that direction.

This problem is commonly asked in interviews and helps build concepts like:
- Recognizing that a ring can only be made strongly connected by orienting it as a single directed cycle
- Traversing a cycle once to accumulate two complementary costs
- Choosing the cheaper of exactly two valid global orientations

which are important for solving problems where the underlying structure limits the space of valid solutions to a small, enumerable set.

**Your task:** Find the smallest amount of money the government should spend on reversing roads so that from every city you can get to any other.

### Input
The first line contains integer `n` (`3 <= n <= 100`), the number of cities (and roads) in the ring.
The next `n` lines each contain a description of a road: three integers `ai, bi, ci` (`1 <= ai, bi <= n`, `ai != bi`, `1 <= ci <= 100`), meaning the road is directed from city `ai` to city `bi`, and reversing the traffic direction costs `ci`.

**Constraints:**
- `3 <= n <= 100`
- `1 <= ci <= 100`
- The edges form exactly one ring of `n` roads.

### Output
Output a single integer: the smallest amount of money the government should spend on reversing roads so that from every city you can get to any other.

### Examples

**Input:**
```
n = 3
1 3 1
1 2 1
3 2 1
```
**Output:**
```
1
```

---

**Input:**
```
n = 3
1 3 1
1 2 5
3 2 1
```
**Output:**
```
2
```

---

**Input:**
```
n = 6
1 5 4
5 3 8
2 4 15
1 6 16
2 3 23
4 6 42
```
**Output:**
```
39
```

---
