class Solution(object):
    def rob(self, nums):
        if len(nums) == 1:
            return(nums[0])
        
        def linear_rob(houses):
            rob_prev2 = 0
            rob_prev1 = 0
            for current_house in houses:
                current_max = max(rob_prev1, rob_prev2 + current_house)
                rob_prev2 = rob_prev1
                rob_prev1 = current_max
            return rob_prev1
        
        return max(linear_rob(nums[1:]), linear_rob(nums[:-1]))