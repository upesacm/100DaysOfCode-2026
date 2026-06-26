#include <vector>
#include <algorithm>

class Solution {
public:
    int rob(std::vector<int>& nums) {
        int n = nums.size();
        
        // Corner cases
        if (n == 1) return nums[0];
        if (n == 2) return std::max(nums[0], nums[1]);
        
        // Max of robbing houses [0 to n-2] OR [1 to n-1]
        return std::max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

private:
    // Helper function to solve the standard linear House Robber I problem
    int robLinear(const std::vector<int>& nums, int start, int end) {
        int prevMax = 0; // Max money if we don't rob the current house
        int currMax = 0; // Max money if we do (or might) rob the current house
        
        for (int i = start; i <= end; ++i) {
            int temp = currMax;
            // Decide whether to rob the current house or skip it
            currMax = std::max(prevMax + nums[i], currMax);
            prevMax = temp;
        }
        
        return currMax;
    }
};