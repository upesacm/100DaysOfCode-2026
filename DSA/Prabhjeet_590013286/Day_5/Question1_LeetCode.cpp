#include <vector>
class Solution {
public:

    bool canJump(vector<int>& nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.size(); i++) {

            if (i > maxReach) { // Current position cannot be reached
                return false;
            }

            maxReach = max(maxReach, i + nums[i]); // Update farthest reachable index
        }

        return true; // Last index can be reached
    }
};