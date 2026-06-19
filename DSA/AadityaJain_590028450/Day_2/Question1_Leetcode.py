'''
Remove Element
Explanation
Given an integer array nums and an integer val, remove all occurrences of val in-place and return the number of remaining elements.
'''

class Solution(object):
    def removeElement(self, nums, val):
        n = len(nums)
        count = 0

        for i in range(n):
            if nums[i]!= val:
                nums[count] = nums[i]
                count += 1
        
        return count
