class Solution(object):
    def canJump(self, nums):
        farthest = 0

        for i in range(len(nums)):
            if i > farthest:
                return False

            farthest = max(farthest, i + nums[i])

        return True


nums = [2, 3, 1, 1, 4]

sol = Solution()
print(sol.canJump(nums))