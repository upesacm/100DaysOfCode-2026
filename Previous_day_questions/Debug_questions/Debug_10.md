<h2 align="center">Week 10 Day 7 (23/08/2026)</h2>

## Hulk Smash Tree

The Avengers recently developed a Binary Search Tree system to store gamma radiation readings collected from around the world. Bruce Banner spent weeks designing and testing the software. Everything worked perfectly. Then Hulk found the server room.

According to security footage, Hulk spent several minutes staring at the monitor before making the following observation: "HULK NOT KNOW COMPUTER." "BANNER SAY COMPUTER IMPORTANT." "BANNER BAD GEEK." "WHY TREE HAVE SO MANY ARROWS?" "WHY NUMBER GO LEFT? WHY NUMBER GO RIGHT?" "HULK SMASH."

The result was catastrophic. Servers were destroyed. Monitors were shattered. And the source code suffered the most damage. During recovery, Banner discovered that Hulk had a particular dislike for comparison operators. Several code fragments were recovered from different servers and merged back together. The recovery team believes some lines inside the BST functions are no longer in their original locations.

Your task is to repair Hulk's damage before he returns for another round of debugging.

This problem is commonly asked in interviews and helps build concepts like:
- Binary Search Trees (BST)
- Recursive insertion and search
- Debugging and code tracing

which are important for solving correctness problems involving BST properties.

**Your task:** Fix all logical bugs and line-ordering issues in the code below so that BST insertion and search work correctly.

### What the code must do
- Restore correct BST insertion — smaller values go left, larger values go right, no duplicate nodes are created.
- Restore correct BST search using the BST property (checking only one side, based on comparison, not both sides).
- Fix all logical errors and rearrange misplaced lines where necessary.
- Ensure the tree satisfies BST properties throughout.
- Preserve the recursive implementation.

### Buggy Code

```python
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def insert(root, value):
    # Hulk recovered these lines from different files.
    # Their order may not be correct.
    if value < root.value:
        root.right = insert(root.right, value)
    if root is None:
        return Node(value)
    elif value > root.value:
        root.left = insert(root.left, value)
    elif value == root.value:
        return Node(value)
    return root

def search(root, target):
    # Hulk may have moved some lines here too.
    if root.value == target:
        return False
    if root is None:
        return True
    if target < root.value:
        return search(root.left, target) or search(root.right, target)
    return search(root.left, target) or search(root.right, target)

root = None
gamma_readings = [50, 30, 70, 20, 40, 60, 80]
for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))
```

### Expected Output

```
True
False
```

### Constraints
- `1 <= Number of Nodes <= 10^5`
- Values are unique integers.
- Tree must satisfy BST properties (left < root < right).
- Recursive implementation must be preserved.
- Duplicate insertions must not create new nodes.

---
