class Solution:
    def betterString(self, s1, s2):
        def countDistinct(s):
            n = len(s)
            dp = [0] * (n + 1)
            dp[0] = 1
            last = {}
            for i in range(1, n + 1):
                dp[i] = 2 * dp[i - 1]

                if s[i - 1] in last:
                    dp[i] -= dp[last[s[i - 1]] - 1]
                last[s[i - 1]] = i
            return dp[n]
        if countDistinct(s1) >= countDistinct(s2):
            return s1
        return s2