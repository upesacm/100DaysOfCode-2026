#include <stdio.h>
#include <string.h>

#define MAX 1000

long long countDistinctSubsequences(char str[]) {
    int n = strlen(str);

    long long dp[MAX + 1];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1;   // Empty subsequence

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        unsigned char ch = str[i - 1];

        if (last[ch] != -1)
            dp[i] -= dp[last[ch]];

        last[ch] = i - 1;
    }

    return dp[n];
}

int main() {
    char s1[1001], s2[1001];

    printf("Enter first string: ");
    scanf("%s", s1);

    printf("Enter second string: ");
    scanf("%s", s2);

    long long count1 = countDistinctSubsequences(s1);
    long long count2 = countDistinctSubsequences(s2);

    if (count1 >= count2)
        printf("%s\n", s1);
    else
        printf("%s\n", s2);

    return 0;
}