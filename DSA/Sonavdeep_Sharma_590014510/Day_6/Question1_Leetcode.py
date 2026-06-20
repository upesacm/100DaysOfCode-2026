class Solution:
    def rob(self, nums: List[int]) -> int:
      

        if len(nums) == 1:
            return nums[0]

        def solve(arr):

            rob1 = 0
            rob2 = 0

            for n in arr:
                temp = max(rob1 + n, rob2)
                rob1 = rob2
                rob2 = temp

            return rob2

        return max(
            solve(nums[:-1]),
            solve(nums[1:])
        )