class Solution:
    def rotate(self, nums, k):
        n = len(nums)
        k = k % n

        return nums[k:] + nums[:k]


# Test
if __name__ == "__main__":
    sol = Solution()

    nums = [1, 2, 3, 4]
    k = 3

    result = sol.rotate(nums, k)

    print("Original Array:", nums)
    print("Rotated Array :", result)