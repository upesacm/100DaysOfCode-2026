#include <vector>
#include <climits>

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* bstFromPreorder(std::vector<int>& preorder) {
        int index = 0;
        return buildTree(preorder, index, INT_MAX);
    }
    
private:
    TreeNode* buildTree(const std::vector<int>& preorder, int& index, int upperBound) {
        // If we consumed all elements or the current element doesn't belong in this subtree
        if (index == preorder.size() || preorder[index] > upperBound) {
            return nullptr;
        }
        
        // The current element is the root of this subtree
        TreeNode* root = new TreeNode(preorder[index++]);
        
        // All elements in the left subtree must be smaller than the root's value
        root->left = buildTree(preorder, index, root->val);
        
        // All elements in the right subtree must be smaller than the inherited upper bound
        root->right = buildTree(preorder, index, upperBound);
        
        return root;
    }
};