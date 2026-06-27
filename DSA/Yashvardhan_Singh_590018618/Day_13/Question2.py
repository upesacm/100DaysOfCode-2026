def count_distinct_subsequences(s):
    n = len(s)

    dp = [0] * (n + 1)
    dp[0] = 1

    last = {}

    for i in range(1, n + 1):
        ch = s[i - 1]
        dp[i] = 2 * dp[i - 1]

        if ch in last:
            dp[i] -= dp[last[ch] - 1]

        last[ch] = i

    return dp[n]


def more_distinct_subsequences(s1, s2):
    count1 = count_distinct_subsequences(s1)
    count2 = count_distinct_subsequences(s2)

    return s1 if count1 >= count2 else s2


s1 = "abc"
s2 = "aac"

print(more_distinct_subsequences(s1, s2))