<h2 align="center">Week 10 Day 69 (22/08/2026)</h2>

## 1. Construct Binary Search Tree from Preorder Traversal (LeetCode #1008)
### Solution
```c
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* build(int* preorder, int* idx, int n, int lower, int upper) {
    if (*idx == n || preorder[*idx] < lower || preorder[*idx] > upper)
        return NULL;
    int val = preorder[*idx];
    (*idx)++;
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = build(preorder, idx, n, lower, val);
    node->right = build(preorder, idx, n, val, upper);
    return node;
}

struct TreeNode* bstFromPreorder(int* preorder, int n) {
    int idx = 0;
    return build(preorder, &idx, n, INT_MIN, INT_MAX);
}
```
* Time: O(n) — each element is consumed exactly once, since the bounds check decides membership without any backtracking.
* Space: O(n) for the recursion stack in the worst case (skewed tree).

Preorder always places a node before its subtree, so the first value is the root, and every following value belongs to the left subtree if it fits under the current upper bound, otherwise it belongs to the right subtree. Passing tightening `(lower, upper)` bounds down the recursion lets the array be consumed in a single left-to-right pass.

---

## 2. The Great Divide
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

struct Node {
    long long val;
    Node* left;
    Node* right;
};

Node* buildTree(vector<long long>& arr, int i, int n) {
    if (i > n || i < 1 || arr[i] == -1) return nullptr;
    Node* node = new Node{arr[i], nullptr, nullptr};
    node->left = buildTree(arr, 2 * i, n);
    node->right = buildTree(arr, 2 * i + 1, n);
    return node;
}

// Splits root into (lessThanK, geqK) using standard BST split
pair<Node*, Node*> split(Node* root, long long K) {
    if (!root) return {nullptr, nullptr};
    if (root->val < K) {
        auto [l, r] = split(root->right, K);
        root->right = l;
        return {root, r};
    } else {
        auto [l, r] = split(root->left, K);
        root->left = r;
        return {l, root};
    }
}

void preorder(Node* root, vector<long long>& out) {
    if (!root) return;
    out.push_back(root->val);
    preorder(root->left, out);
    preorder(root->right, out);
}

void printBranch(Node* root) {
    vector<long long> out;
    preorder(root, out);
    if (out.empty()) {
        cout << "EMPTY\n";
        return;
    }
    for (size_t i = 0; i < out.size(); i++) {
        cout << out[i] << (i + 1 < out.size() ? ' ' : '\n');
    }
}

int main() {
    int n;
    long long K;
    cin >> n;
    vector<long long> arr(n + 1);
    for (int i = 1; i <= n; i++) cin >> arr[i];
    cin >> K;

    Node* root = buildTree(arr, 1, n);
    auto [branchA, branchB] = split(root, K);

    printBranch(branchA);
    printBranch(branchB);
    return 0;
}
```
* Time: O(n) — each node is visited exactly once during the split, and once more during its branch's preorder printout.
* Space: O(n) for the recursion stack plus the output vectors; no new nodes are allocated, existing ones are just relinked.

The split works by recursively peeling off values on the "wrong side" of `K` and reattaching them to the other branch. If a node's value is less than `K`, it belongs in Branch A, so its right subtree (which may still contain values `>= K`) gets recursively split and the smaller-than-K part gets attached back to Branch A's right pointer. The symmetric logic handles nodes `>= K` for Branch B, and because BST ordering is preserved at every relink, both resulting trees remain valid BSTs.
