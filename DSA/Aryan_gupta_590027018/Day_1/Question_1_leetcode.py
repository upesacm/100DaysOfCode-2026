class Solution(object):
    def missingNumber(self, nums):
        nums.sort()

        left = 0
        right = len(nums)

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > mid:
                right = mid
            else:
                left = mid + 1

        return left
