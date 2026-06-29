#include <stdio.h>
#include <string.h>

long long countDistinct(char s[]) {

    int n = strlen(s);

    long long dp[n + 1];
    int last[256];

    for (int i = 0; i < 256; i++)
        last[i] = -1;

    dp[0] = 1;

    for (int i = 1; i <= n; i++) {

        dp[i] = 2 * dp[i - 1];

        unsigned char c = s[i - 1];

        if (last[c] != -1)
            dp[i] -= dp[last[c]];

        last[c] = i - 1;
    }

    return dp[n];
}

char* betterString(char s1[], char s2[]) {
    return (countDistinct(s1) >= countDistinct(s2))
           ? s1
           : s2;
}

int main() {
    char s1[] = "abc";
    char s2[] = "aac";

    printf("%s\n", betterString(s1, s2));

    return 0;
}