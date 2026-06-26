class Solution:
    def canJump(self, nums) :
        if nums[0] == 1 and len(nums) == 1:
            return True
        hold = 0    

        for i in range(len(nums)):
            if i > hold:
                return False

            hold = max(hold, i + nums[i])

        return True