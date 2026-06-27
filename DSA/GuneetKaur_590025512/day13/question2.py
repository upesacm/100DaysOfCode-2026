class Solution:

    def countDistinct(self, s):
        n = len(s)

        dp = [0] * (n + 1)
        dp[0] = 1

        last = {}

        for i in range(1, n + 1):

            dp[i] = 2 * dp[i - 1]

            ch = s[i - 1]

            if ch in last:
                dp[i] -= dp[last[ch] - 1]

            last[ch] = i

        return dp[n]

    def betterString(self, s1, s2):

        x = self.countDistinct(s1)
        y = self.countDistinct(s2)

        if x >= y:
            return s1

        return s2