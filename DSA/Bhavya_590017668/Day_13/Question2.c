#include <stdio.h>
#include <string.h>
#include <stdlib.h>

long long countDistinct(char *s) {
    int n = strlen(s);
    long long dp[n + 1];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        char ch = s[i - 1];

        if (last[(unsigned char)ch] != -1) {
            dp[i] -= dp[last[(unsigned char)ch]];
        }

        last[(unsigned char)ch] = i - 1;
    }

    return dp[n];
}

char* betterString(char* str1, char* str2) {
    long long count1 = countDistinct(str1);
    long long count2 = countDistinct(str2);

    if (count1 >= count2)
        return str1;
    else
        return str2;
}