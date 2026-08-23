<h2 align="center">Week 10 Day 6 (22/08/2026)</h2>

## 1. Construct Binary Search Tree from Preorder Traversal (LeetCode #1008)
A problem that teaches BST construction and recursive partitioning techniques by rebuilding a tree from its preorder sequence. Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root. It is guaranteed that it is always possible to find a binary search tree with the given requirements for the given test cases. A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val. A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Preorder traversal
- Recursive tree construction

which are important for solving tree-reconstruction problems from traversal sequences.

**Your task:** Construct the BST from the given preorder traversal and return its root.

### Input
An integer array `preorder`, as described above.

**Constraints:**
- `1 <= preorder.length <= 100`
- `1 <= preorder[i] <= 1000`
- All the values of preorder are unique.

### Output
Return the root of the constructed BST.

### Examples

**Input:**
```
preorder = [8,5,1,7,10,12]
```
**Output:**
```
[8,5,10,1,7,null,12]
```

---

**Input:**
```
preorder = [1,3]
```
**Output:**
```
[1,null,3]
```

---

## 2. The Great Divide
A national bank stores all of its safe-deposit boxes in a Binary Search Tree (BST). Each node contains a unique box number. Due to new regulations, the bank must split the entire system into two separate branches. The split is based on a value K: Branch A will contain all boxes with numbers less than K, and Branch B will contain all boxes with numbers greater than or equal to K. After the split, both branches must still be valid BSTs, every original node must belong to exactly one of the two branches, and no new nodes should be created.

This problem is commonly asked in interviews and helps build concepts like:
- BST properties (ordering)
- Tree splitting / restructuring
- Preorder traversal output

which are important for solving BST-partitioning and tree-restructuring problems.

**Your task:** Split the BST using the value K and output the preorder traversal of the two resulting trees. If a tree is empty, print EMPTY.

### Input
An integer `n`, a level-order array `tree`, and an integer `K`, as described above.

**Constraints:**
- `1 <= n <= 10000`
- `-1 <= tree[i] <= 10^9` (-1 represents a null node)
- All non-null values are distinct.

### Output
Print the preorder traversal of Branch A on the first line and Branch B on the second line, printing EMPTY for an empty branch.

### Examples

**Input:**
```
n = 7
tree = [10, 5, 15, 2, 7, 12, 20]
K = 10
```
**Output:**
```
5 2 7
10 15 12 20
```

---

**Input:**
```
n = 3
tree = [2, 1, 3]
K = 5
```
**Output:**
```
2 1 3
EMPTY
```

---

**Input:**
```
n = 1
tree = [5]
K = 5
```
**Output:**
```
EMPTY
5
```

---
