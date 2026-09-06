// Leetcode Problem 1382
// Balance a Binary Search Tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int arr[10000];
int idx = 0;

void inorder(struct TreeNode* root) {
    if (root == NULL)
        return;
    inorder(root->left);
    arr[idx++] = root->val;
    inorder(root->right);
}

struct TreeNode* buildTree(int start, int end) {
    if (start > end)
        return NULL;
    int mid = (start + end) / 2;
    struct TreeNode* root = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    root->val = arr[mid];
    root->left = buildTree(start, mid - 1);
    root->right = buildTree(mid + 1, end);
    return root;
}

struct TreeNode* balanceBST(struct TreeNode* root) {
    idx = 0;
    inorder(root);
    return buildTree(0, idx - 1);
}