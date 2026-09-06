#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

pair<int, int> solve(vector<int>& tree, int i) {
    if (i >= tree.size() || tree[i] == -1)
        return {0, 0};

    pair<int, int> left = solve(tree, 2 * i + 1);
    pair<int, int> right = solve(tree, 2 * i + 2);

    int rob = tree[i] + left.second + right.second;

    int skip = max(left.first, left.second)
             + max(right.first, right.second);

    return {rob, skip};
}

int main() {
    int n;
    cin >> n;

    vector<int> tree(n);

    for (int i = 0; i < n; i++)
        cin >> tree[i];

    pair<int, int> ans = solve(tree, 0);

    cout << max(ans.first, ans.second) << '\n';

    return 0;
}