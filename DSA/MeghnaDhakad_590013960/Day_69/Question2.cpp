#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Recursive preorder traversal on the array-based BST
void preorderSplit(const vector<int>& tree, int idx, int K, string& lessStr, string& greaterStr) {
    // Base case: Out of bounds or missing node (-1)
    if (idx >= tree.size() || tree[idx] == -1) {
        return;
    }
    
    int val = tree[idx];
    
    // Append to the respective string based on the threshold K
    if (val < K) {
        if (!lessStr.empty()) lessStr += " ";
        lessStr += to_string(val);
    } else {
        if (!greaterStr.empty()) greaterStr += " ";
        greaterStr += to_string(val);
    }
    
    // Traverse left and right children (preorder: Root -> Left -> Right)
    preorderSplit(tree, 2 * idx + 1, K, lessStr, greaterStr);
    preorderSplit(tree, 2 * idx + 2, K, lessStr, greaterStr);
}

vector<string> splitBSTPreorder(const vector<int>& tree, int K) {
    string lessStr = "";
    string greaterStr = "";
    
    preorderSplit(tree, 0, K, lessStr, greaterStr);
    
    // Handle empty branches
    if (lessStr.empty()) lessStr = "EMPTY";
    if (greaterStr.empty()) greaterStr = "EMPTY";
    
    return {lessStr, greaterStr};
}

int main() {
    vector<int> tree = {10, 5, 15, 2, 7, 12, 20};
    int K = 10;
    
    vector<string> result = splitBSTPreorder(tree, K);
    
    cout << "Output: [\"" << result[0] << "\", \"" << result[1] << "\"]\n";
    // Expected Output: ["5 2 7", "10 15 12 20"]
    
    return 0;
}