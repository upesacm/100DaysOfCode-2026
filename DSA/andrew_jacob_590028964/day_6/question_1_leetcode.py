class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        def rob_linear(houses):
            prev2, prev1 = 0, 0
            for money in houses:
                prev2, prev1 = prev1, max(prev1, prev2 + money)
            return prev1
        
        return max(rob_linear(nums[:-1]), rob_linear(nums[1:]))
