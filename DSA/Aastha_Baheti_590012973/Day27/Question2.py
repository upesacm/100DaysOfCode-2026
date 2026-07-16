class Solution:
    def countSubarrays(self, arr, l, r):
        def count(limit):
            ans = 0
            curr = 0

            for num in arr:
                if num <= limit:
                    curr += 1
                else:
                    curr = 0
                ans += curr

            return ans

        return count(r) - count(l - 1)