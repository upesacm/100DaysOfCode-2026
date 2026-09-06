<h2 align="center">Week 11 Day 71 (24/08/2026)</h2>

## 1. Find the Town Judge (LeetCode #997)

A problem that teaches degree-based reasoning on directed relationships by identifying a node that everybody points to but which points to nobody. In a town, there are `n` people labeled from 1 to n, and there is a rumor that one of these people is secretly the town judge. If the town judge exists, then the town judge trusts nobody, everybody (except for the town judge) trusts the town judge, and there is exactly one person that satisfies both of these properties. You are given an array `trust` where `trust[i] = [a, b]` represents that the person labeled `a` trusts the person labeled `b`. If a trust relationship does not exist in the trust array, then such a trust relationship does not exist.

This problem is commonly asked in interviews and helps build concepts like:
- In-degree / out-degree reasoning on a directed graph
- Array-based frequency (net score) counting
- Identifying a unique node satisfying degree constraints

which are important for solving problems involving directed relationships and degree-based node identification.

**Your task:** Determine and return the label of the town judge if one exists and can be uniquely identified; otherwise return -1.

### Input
An integer `n` and a 2D integer array `trust`, as described above.

**Constraints:**
- `1 <= n <= 1000`
- `0 <= trust.length <= 10^4`
- `trust[i].length == 2`
- All the pairs of `trust` are unique.
- `ai != bi`
- `1 <= ai, bi <= n`

### Output
Return the label of the town judge (or -1 if not found).

### Examples

**Input:**
```
n = 2, trust = [[1,2]]
```
**Output:**
```
2
```

---

**Input:**
```
n = 3, trust = [[1,3],[2,3]]
```
**Output:**
```
3
```

---

**Input:**
```
n = 3, trust = [[1,3],[2,3],[3,1]]
```
**Output:**
```
-1
```

---

## 2. Grid Encryption
A problem that teaches Grid Construction and String Manipulation — arranging text in a matrix and reading column-wise instead of row-wise. Related topics: Matrix manipulation, String processing, Grid layout.

Aryan needs to encrypt a message using the following encryption scheme. First, all spaces are removed from the text, giving a string of length `L`. The characters are then written row by row into a grid with `columns = ceil(sqrt(L))` and `rows = ceil(L / columns)`, so that the grid has just enough cells to hold all `L` characters (the final row may be only partially filled). The encoded message is obtained by reading the characters of the grid column by column (top to bottom within a column, left to right across columns), skipping any empty cells in a partially filled last row, with a space separating the text produced by each column.

This problem is commonly asked in interviews and helps build concepts like:
- Computing grid dimensions from a target length
- Row-major filling of a 2D character grid
- Column-wise traversal and reconstruction

which are important for solving cipher/encoding-style problems that rearrange characters through a grid.

**Your task:** Encrypt the given string using the grid-construction scheme described above and return the resulting encoded message.

### Input
One line of text, the string `s` (contains lowercase letters and spaces).

**Constraints:**
- `1 <= |s| <= 10^5`
- Characters: lowercase letters a–z and space

### Output
Print the encrypted string.

### Examples

**Input:**
```
haveaniceday
```
**Output:**
```
hae and via ecy
```

---

**Input:**
```
feedthedog
```
**Output:**
```
fto ehg ee dd
```

---

**Input:**
```
chillout
```
**Output:**
```
clu hlt io
```

---
