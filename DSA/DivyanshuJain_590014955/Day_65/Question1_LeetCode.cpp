

 
 
#include<iostream>
#include<unordered_map>
using namespace std;
class Solution {
public:
 struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };
    unordered_map<int,int>mp;
    void fun(TreeNode* root){
        if(root==NULL) return;
        mp[root->val]++;
        fun(root->left);
        fun(root->right);
    }
    vector<int> findMode(TreeNode* root) {
        fun(root);
        vector<int>ans;
        int fmax=INT_MIN;
        for(auto ele:mp){
            if(ele.second>fmax) fmax = ele.second;
        }
        for(auto ele:mp){
            if(ele.second==fmax) ans.push_back(ele.first);
        }
        return ans;
    }
};