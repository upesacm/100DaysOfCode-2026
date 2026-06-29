#include <stdio.h>
#include <string.h>

long long countDistinctSubsequences(const char *str)
{
    int n = strlen(str);

    long long dp[n + 1];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1;   // Empty subsequence

    for (int i = 1; i <= n; i++)
    {
        dp[i] = 2 * dp[i - 1];

        unsigned char ch = (unsigned char)str[i - 1];

        if (last[ch] != -1)
            dp[i] -= dp[last[ch] - 1];

        last[ch] = i;
    }

    return dp[n];
}

const char* betterString(const char *s1, const char *s2)
{
    if (countDistinctSubsequences(s1) >= countDistinctSubsequences(s2))
        return s1;

    return s2;
}

int main()
{
    char s1[1001], s2[1001];

    scanf("%1000s %1000s", s1, s2);

    printf("%s\n", betterString(s1, s2));

    return 0;
}