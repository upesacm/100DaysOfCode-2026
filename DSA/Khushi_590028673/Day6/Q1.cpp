#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int robLine(vector<int>& nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            int curr = max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    int rob(vector<int>& nums) {
        int n = nums.size();

        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return max(
            robLine(nums, 0, n - 2), // Exclude last house
            robLine(nums, 1, n - 1)  // Exclude first house
        );
    }
};

int main() {
    Solution sol;

    vector<int> nums = {2, 3, 2};

    cout << "Maximum money that can be robbed: "
         << sol.rob(nums) << endl;

    return 0;
}
