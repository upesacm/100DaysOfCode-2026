class Solution:
    def triangleNumber(self, nums):
        # handle small arrays quickly
        if not nums or len(nums) < 3:
            return 0

        nums.sort()
        n = len(nums)
        count = 0

        # k is index of the largest side
        for k in range(n - 1, 1, -1):
            i, j = 0, k - 1
            while i < j:
                if nums[i] + nums[j] > nums[k]:
                    # all elements from i..(j-1) with nums[j] work
                    count += (j - i)
                    j -= 1
                else:
                    i += 1
        return count

# local quick test
if __name__ == "__main__":
    print(Solution().triangleNumber([2,2,3,4]))  # 3
    print(Solution().triangleNumber([4,2,3,4]))  # 4
