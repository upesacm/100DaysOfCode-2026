#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestWindow(char str[]) {
    int n = strlen(str);
    int visited[256] = {0};
    int distinct = 0;

    // Count total distinct characters
    for (int i = 0; i < n; i++) {
        if (visited[(unsigned char)str[i]] == 0) {
            visited[(unsigned char)str[i]] = 1;
            distinct++;
        }
    }

    int freq[256] = {0};
    int start = 0, count = 0;
    int minLen = INT_MAX;

    for (int end = 0; end < n; end++) {
        freq[(unsigned char)str[end]]++;

        if (freq[(unsigned char)str[end]] == 1)
            count++;

        while (count == distinct) {
            int windowLen = end - start + 1;

            if (windowLen < minLen)
                minLen = windowLen;

            freq[(unsigned char)str[start]]--;

            if (freq[(unsigned char)str[start]] == 0)
                count--;

            start++;
        }
    }

    return minLen;
}

int main() {
    char str[1000];
    scanf("%s", str);

    printf("%d", smallestWindow(str));

    return 0;
}