class Solution(object):
    def removeElement(self, nums, val):
        k = 0

        for i in range(len(nums)):
            if nums[i] != val:
                nums[k] = nums[i]
                k += 1

        return k


nums = list(map(int, input("Enter the array elements separated by spaces: ").split()))
val = int(input("Enter the value to remove: "))

sol = Solution()
k = sol.removeElement(nums, val)

print("k =", k)
print("Updated array =", nums[:k])