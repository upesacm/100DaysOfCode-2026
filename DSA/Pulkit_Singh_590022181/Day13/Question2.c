#include <stdio.h>
#include <string.h>

#define MAX 1005

long long countDistinctSubsequences(char str[]) {
    int n = strlen(str);

    long long dp[MAX];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1; // Empty subsequence

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        if (last[(unsigned char)str[i - 1]] != -1)
            dp[i] -= dp[last[(unsigned char)str[i - 1]] - 1];

        last[(unsigned char)str[i - 1]] = i;
    }

    return dp[n];
}

int main() {
    char s1[1005], s2[1005];

    scanf("%s", s1);
    scanf("%s", s2);

    long long count1 = countDistinctSubsequences(s1);
    long long count2 = countDistinctSubsequences(s2);

    if (count1 >= count2)
        printf("%s\n", s1);
    else
        printf("%s\n", s2);

    return 0;
}