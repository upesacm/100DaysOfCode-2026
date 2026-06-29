#Determine which of the two given strings has more distinct subsequences, 
#returning the first string if both have the same number.
#Input:s1="abc" , s2="aac". Output:"abc"
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

def moreDistinctSubsequence(s1, s2):
    if countDistinct(s1) >= countDistinct(s2):
        return s1
    else:
        return s2
s1 = input("Enter string: ")
s2 = input("Enter string: ")
print(moreDistinctSubsequence(s1, s2))