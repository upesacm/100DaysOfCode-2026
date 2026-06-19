class Solution:
    def canJump(self, nums):
        farthest = 0

        for i in range(len(nums)):
            if i > farthest:
                return False

            farthest = max(farthest, i + nums[i])

            if farthest >= len(nums) - 1:
                return True

        return True


# 🔽 For VS Code testing (you can remove before LeetCode submit)
if __name__ == "__main__":
    s = Solution()

    nums1 = [2, 3, 1, 1, 4]
    nums2 = [3, 2, 1, 0, 4]

    print(s.canJump(nums1))  # True
    print(s.canJump(nums2))  # False