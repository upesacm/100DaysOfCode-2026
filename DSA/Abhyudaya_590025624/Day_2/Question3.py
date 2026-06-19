class Solution(object):
    def removeElement(self, nums, val):
        k=0
        for i in range(len(nums)):
            if nums[i] != val:
                nums[k]=nums[i]
                k+=1
        return k
#Leetcode solution ends here...below is just a test case to check my code.
nums = [3, 2, 2, 3]
val = 3
obj = Solution()
print(obj.removeElement(nums, val))
