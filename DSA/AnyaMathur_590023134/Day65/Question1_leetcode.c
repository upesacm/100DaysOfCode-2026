// Leetcode Problem 501
// Find Mode in Binary Search Tree

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

int prev;
int count = 0;
int maxCount = 0;
int modeCount = 0;
int *modes;

void inorder(struct TreeNode* root) {
    if (root == NULL)
        return;
    inorder(root->left);
    if (count == 0 || root->val != prev)
        count = 1;
    else
        count++;
    if (count > maxCount) {
        maxCount = count;
        modeCount = 1;
        modes[0] = root->val;
    }
    else if (count == maxCount) {
        modes[modeCount] = root->val;
        modeCount++;
    }
    prev = root->val;
    inorder(root->right);
}

int* findMode(struct TreeNode* root, int* returnSize) {
    modes = (int*)malloc(10000 * sizeof(int));
    count = 0;
    maxCount = 0;
    modeCount = 0;
    inorder(root);
    *returnSize = modeCount;
    return modes;
}