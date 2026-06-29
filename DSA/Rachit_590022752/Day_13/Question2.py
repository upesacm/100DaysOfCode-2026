class Solution:
    def countDistinct(self, s):
        dp = [1]
        last = {}

        for i in range(len(s)):
            curr = dp[-1] * 2

            if s[i] in last:
                curr -= dp[last[s[i]]]

            last[s[i]] = i
            dp.append(curr)

        return dp[-1]

    def betterString(self, str1, str2):
        if self.countDistinct(str1) >= self.countDistinct(str2):
            return str1
        else:
            return str2

str1 = input("Enter first string: ")
str2 = input("Enter second string: ")

obj = Solution()

result = obj.betterString(str1, str2)
print("Better String:", result)
