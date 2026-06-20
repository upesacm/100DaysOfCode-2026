# leetcode problem 213
# House Robber II

class Solution(object):
    def rob(self, nums):

        if len(nums) == 1:
            return nums[0]

        a = 0
        b = 0

        for money in nums[:-1]:
            temp = max(b, a + money)
            a = b
            b = temp

        answer1 = b

        a = 0
        b = 0

        for money in nums[1:]:
            temp = max(b, a + money)
            a = b
            b = temp

        answer2 = b

        return max(answer1, answer2)