'''
Jump Game
Explanation
Given an array where each element represents the maximum jump length from that position, determine whether you can reach the last index.
'''

class Solution(object):
    def canJump(self, nums):

        jump = 0

        for i in range(len(nums)):
            if i > jump:
                return False

            jump = max(jump, i + nums[i])

            if jump >= len(nums) - 1:
                return True
           
        return True