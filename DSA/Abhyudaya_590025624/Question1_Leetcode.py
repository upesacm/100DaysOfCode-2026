class Solution(object):
    def missingNumber(self, nums):
        num=0
        for i in range(len(nums)+1):
            if i in nums:
                continue
            else:
                num=i
        return num       
#Leetcode solution ends here...below is just a test case to check my code.
nums = [3, 0, 1]
obj = Solution()
print(obj.missingNumber(nums))
