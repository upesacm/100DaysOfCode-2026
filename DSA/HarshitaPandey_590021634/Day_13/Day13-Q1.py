"""  Q1:Determine which of the two given strings has more distinct subsequences, returning the first string if 
both have the same number.

Example:
Input:s1="abc" , s2="aac". Output:"abc"   """


def distinct_subsequences(s):
    n = len(s)
    dp = [0] * (n + 1)
    dp[0] = 1  

    last_occurrence = {}

    for i in range(1, n + 1):
        dp[i] = 2 * dp[i - 1]  

        if s[i - 1] in last_occurrence:

            dp[i] -= dp[last_occurrence[s[i - 1]] - 1] 

        last_occurrence[s[i - 1]] = i

    return dp[n]