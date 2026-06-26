class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        maxReach = 0
        for i in range(len(nums)):
            if i > maxReach: 
                return False
            maxReach = max(maxReach, i + nums[i])
        return True
