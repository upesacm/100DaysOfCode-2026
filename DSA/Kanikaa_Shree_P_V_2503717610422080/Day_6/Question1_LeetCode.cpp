class Solution {
public:
    int RLine(vector<int>& nums, int start, int end) {
        int P1 = 0, P2 = 0;

        for(int i = start; i <= end; i++) {
            int C = max(P1, P2 + nums[i]);
            P2 = P1;
            P1 = C;
        }

        return P1;
    }

    int rob(vector<int>& nums) {
        int n = nums.size();

        if(n == 1)
            return nums[0];

        return max(RLine(nums, 0, n - 2),
                   RLine(nums, 1, n - 1));
    }
        
    
};