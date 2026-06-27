def countDistinctSubsequences(s):
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


def betterString(s1, s2):
    count1 = countDistinctSubsequences(s1)
    count2 = countDistinctSubsequences(s2)

    if count1 >= count2:
        return s1
    return s2


# Example
s1 = "abc"
s2 = "aac"

print(betterString(s1, s2))
