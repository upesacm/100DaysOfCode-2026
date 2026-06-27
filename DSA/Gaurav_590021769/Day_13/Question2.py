def count_distinct_subsequences(s):
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


def string_with_more_subsequences(s1, s2):
    c1 = count_distinct_subsequences(s1)
    c2 = count_distinct_subsequences(s2)

    if c1 >= c2:
        return s1
    else:
        return s2


# Example
s1 = "abc"
s2 = "aac"

print(string_with_more_subsequences(s1, s2))