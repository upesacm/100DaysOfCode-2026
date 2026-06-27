#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestDistinctWindow(char *s) {
    int n = strlen(s);

    // Count total distinct characters
    int visited[256] = {0};
    int distinct = 0;

    for (int i = 0; i < n; i++) {
        if (!visited[(unsigned char)s[i]]) {
            visited[(unsigned char)s[i]] = 1;
            distinct++;
        }
    }

    int freq[256] = {0};
    int left = 0, count = 0;
    int minLen = INT_MAX;

    for (int right = 0; right < n; right++) {
        if (freq[(unsigned char)s[right]] == 0)
            count++;

        freq[(unsigned char)s[right]]++;

        while (count == distinct) {
            if (right - left + 1 < minLen)
                minLen = right - left + 1;

            freq[(unsigned char)s[left]]--;

            if (freq[(unsigned char)s[left]] == 0)
                count--;

            left++;
        }
    }

    return minLen;
}

int main() {
    char s[1001];

    scanf("%s", s);

    printf("%d\n", smallestDistinctWindow(s));

    return 0;
}