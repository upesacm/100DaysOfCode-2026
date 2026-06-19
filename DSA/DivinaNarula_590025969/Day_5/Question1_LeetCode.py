class Solution:
    def canJump(self, nums):
        last = len(nums) - 1
        reach = 0

        for i, jump in enumerate(nums):
            if i > reach:
                return False

            if i + jump > reach:
                reach = i + jump

            if reach >= last:
                return True

        return True