#include <stdio.h>
#include <string.h>

long long count_distinct_ss(char* s) {
    int len = strlen(s);
    int arr[95];
    memset(arr, -1, sizeof(arr));
    long long dp[len+1];

    dp[0] = 1;

    for (int i = 0; i<len; i++) {
        int id = s[i] - 32;

        if (arr[id] == -1) dp[i+1] = 2*dp[i];
        else dp[i+1] = 2*dp[i] - dp[arr[id]];

        arr[id] = i;
    }
    return dp[len];
}

int main(){
    char s1[1000], s2[1000];
    printf("Enter first string: ");
    fgets(s1, sizeof(s1), stdin);
    s1[strcspn(s1, "\r\n")] = '\0';

    printf("Enter second string: ");
    fgets(s2, sizeof(s2), stdin);
    s2[strcspn(s2, "\r\n")] = '\0';

    char *ans = (count_distinct_ss(s1) >= count_distinct_ss(s2)) ? s1 : s2;

    printf("%s", ans);
}