#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestDistinctWindow(char str[]) {
    int n = strlen(str);

    int distinct[256] = {0};
    int totalDistinct = 0;

    // Count total distinct characters
    for (int i = 0; i < n; i++) {
        if (!distinct[(unsigned char)str[i]]) {
            distinct[(unsigned char)str[i]] = 1;
            totalDistinct++;
        }
    }

    int freq[256] = {0};
    int formed = 0;
    int left = 0;
    int ans = INT_MAX;

    for (int right = 0; right < n; right++) {

        freq[(unsigned char)str[right]]++;

        if (freq[(unsigned char)str[right]] == 1)
            formed++;

        while (formed == totalDistinct) {

            int len = right - left + 1;
            if (len < ans)
                ans = len;

            freq[(unsigned char)str[left]]--;

            if (freq[(unsigned char)str[left]] == 0)
                formed--;

            left++;
        }
    }

    return ans;
}

int main() {
    char str[] = "abcda";

    printf("%d\n", smallestDistinctWindow(str));

    return 0;
}