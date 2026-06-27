#include <stdio.h>
#include <string.h>

int countDistinctSubsequences(char* s) {
    int n = strlen(s);
    int dp[n + 1];
    dp[0] = 1;
    
    int last_seen[256];
    memset(last_seen, -1, sizeof(last_seen));
    
    for (int i = 1; i <= n; i++) {
        char ch = s[i - 1];
        dp[i] = 2 * dp[i - 1];
        
        if (last_seen[(unsigned char)ch] != -1) {
            int prev_idx = last_seen[(unsigned char)ch];
            dp[i] = dp[i] - dp[prev_idx - 1];
        }
        
        last_seen[(unsigned char)ch] = i;
    }
    
    return dp[n];
}

char* betterString(char* s1, char* s2) {
    int count1 = countDistinctSubsequences(s1);
    int count2 = countDistinctSubsequences(s2);
    
    if (count1 >= count2) {
        return s1;
    }
    return s2;
}

int main() {
    char s1[] = "abc";
    char s2[] = "aac";
    
    char* result = betterString(s1, s2);
    
    printf("%s\n", result);
    
    return 0;
}