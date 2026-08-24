<h2 align="center">Week 10 Day 70 (23/08/2026)</h2>

## 1. Hulk Smash Tree — BST Insert & Search Bug Fix

### Bugs found in the original code

1. **`insert`**: the `if root is None: return Node(value)` base case was placed *after* `if value < root.value: ...`, which dereferences `root.value` before checking whether `root` is `None` — this crashes on the very first insertion. The base case must be checked first.
2. **`insert`**: the left/right assignments were swapped — `value < root.value` was sending the recursive call to `root.right`, and `value > root.value` was sending it to `root.left`. That's backwards for a BST (smaller values belong on the left, larger on the right).
3. **`insert`**: the `elif value == root.value: return Node(value)` branch created a brand-new node for a duplicate value instead of just leaving the tree unchanged — violating the "no duplicate nodes" requirement. The fix removes this branch entirely (falling through to `return root` with no modification).
4. **`search`**: `if root.value == target: return False` had the match case backwards — finding the target should return `True`.
5. **`search`**: `if root is None: return True` also had it backwards — running off the tree without finding the target means the value doesn't exist, so this should return `False`. It also needed to be checked *before* `root.value == target` to avoid crashing on a `None` root.
6. **`search`**: both the `target < root.value` and the fallback branch called `search(root.left, target) or search(root.right, target)` — searching *both* subtrees regardless of the comparison. That ignores the BST property entirely (and silently masks bug #2/#3, since a broken tree would still "work" if you brute-force search everywhere). The fix searches only the correct side: left if `target < root.value`, right otherwise.

### Solution

```python
class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None


def insert(root, value):
    if root is None:
        return Node(value)

    if value < root.value:
        root.left = insert(root.left, value)
    elif value > root.value:
        root.right = insert(root.right, value)
    # value == root.value: duplicate, do nothing (no new node created)

    return root


def search(root, target):
    if root is None:
        return False

    if root.value == target:
        return True

    if target < root.value:
        return search(root.left, target)
    else:
        return search(root.right, target)


root = None
gamma_readings = [50, 30, 70, 20, 40, 60, 80]
for reading in gamma_readings:
    root = insert(root, reading)

print(search(root, 60))
print(search(root, 25))
```

### Output

```
True
False
```

Matches the expected output exactly. `insert` now correctly places smaller values to the left and larger values to the right, leaves duplicates untouched, and `search` follows the BST property by descending into exactly one subtree per comparison instead of blindly checking both.

Complexity: O(h) time per `insert`/`search` call, where `h` is the tree height (O(log n) for a balanced tree, O(n) worst case for a skewed one). O(h) extra space for the recursion stack.
