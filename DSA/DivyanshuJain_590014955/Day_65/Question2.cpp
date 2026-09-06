#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int solve(vector<int>& tree, double target) {
    int i = 1;

    int closest = -1;
    double bestDiff = 1e18;

    while (i < tree.size() && tree[i] != -1) {

        int val = tree[i];
        double diff = abs(val - target);

        if (diff < bestDiff ||
            (diff == bestDiff && val < closest)) {
            
            closest = val;
            bestDiff = diff;
        }

        if (val == target)
            return val;

        if (target < val)
            i = 2 * i;
        else
            i = 2 * i + 1;
    }

    return closest;
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;

        vector<int> tree(n + 1);

        for (int i = 1; i <= n; i++)
            cin >> tree[i];

        double target;
        cin >> target;

        cout << solve(tree, target) << '\n';
    }

    return 0;
}