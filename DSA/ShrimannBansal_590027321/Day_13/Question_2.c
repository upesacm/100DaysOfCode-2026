#include <stdio.h>
#include <string.h>

long long countDistinctSubsequences(char str[])
{
    int n = strlen(str);

    long long dp[n + 1];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1;

    for (int i = 1; i <= n; i++)
    {
        dp[i] = 2 * dp[i - 1];

        unsigned char ch = str[i - 1];

        if (last[ch] != -1)
            dp[i] -= dp[last[ch] - 1];

        last[ch] = i;
    }

    return dp[n];
}

char* betterString(char s1[], char s2[])
{
    long long count1 = countDistinctSubsequences(s1);
    long long count2 = countDistinctSubsequences(s2);

    if (count1 >= count2)
        return s1;
    else
        return s2;
}

int main()
{
    char s1[1001], s2[1001];

    scanf("%s %s", s1, s2);

    printf("%s", betterString(s1, s2));

    return 0;
}