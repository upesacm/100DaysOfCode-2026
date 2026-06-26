class Solution:
    def canJump(self, nums):
        farthest = 0
        i = 0

        while i < len(nums):
            if i > farthest:
                return False

            farthest = max(farthest, i + nums[i])
            i += 1

        return True
        