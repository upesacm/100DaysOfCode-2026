class Solution {
public:
       int robHouses(vector<int>& nums, int start, int end) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = start; i <= end; i++) {
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int current = max(pick, notPick);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 1) {
            return nums[0];
        }
        int first = robHouses(nums, 0, n - 2);
        int second = robHouses(nums, 1, n - 1);
        return max(first, second);
    }
};
