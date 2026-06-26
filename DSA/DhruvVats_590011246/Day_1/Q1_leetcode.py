class Solution(object):
    def sumArray(self, nums):
        total = 0
          for i in nums:
            total += i
        return total
nums = [12, 35, 1, 10, 34, 1]
obj = Solution()
print(obj.sumArray(nums))
