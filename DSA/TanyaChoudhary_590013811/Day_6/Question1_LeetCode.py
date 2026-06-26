class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]
        
        def robLine(houses):
            prev2 = 0
            prev1 = 0
            
            for money in houses:
                curr = max(prev1, prev2 + money)
                prev2 = prev1
                prev1 = curr
            
            return prev1