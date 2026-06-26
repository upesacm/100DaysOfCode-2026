// Q1 Jump Game

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        int farthest = 0;

        for (int i = 0; i < nums.size(); i++) {
            // If current index is unreachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest reachable index
            farthest = max(farthest, i + nums[i]);

            // If we can already reach the last index
            if (farthest >= nums.size() - 1) {
                return true;
            }
        }

        return true;
    }
};

int main() {
    int n;

    cout << "Enter size of array: ";
    cin >> n;

    vector<int> nums(n);

    cout << "Enter elements: ";
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    Solution obj;

    if (obj.canJump(nums)) {
        cout << "true" << endl;
    } else {
        cout << "false" << endl;
    }

    return 0;
}
