class Solution:
    def removeElement(self, nums, val):
        k = 0

        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1

        return k

nums = [3, 2, 2, 3]
val = 3

obj = Solution()
k = obj.removeElement(nums, val)

print("k =", k)
print("Updated array =", nums[:k])