#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestDistinctWindow(char str[]) {
    int n = strlen(str);

    // Count total distinct characters
    int visited[256] = {0};
    int distinct = 0;

    for (int i = 0; i < n; i++) {
        if (!visited[(unsigned char)str[i]]) {
            visited[(unsigned char)str[i]] = 1;
            distinct++;
        }
    }

    int freq[256] = {0};
    int start = 0, startIndex = 0;
    int count = 0;
    int minLen = INT_MAX;

    for (int end = 0; end < n; end++) {
        freq[(unsigned char)str[end]]++;

        if (freq[(unsigned char)str[end]] == 1)
            count++;

        // Shrink the window
        while (count == distinct) {
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
                startIndex = start;
            }

            freq[(unsigned char)str[start]]--;

            if (freq[(unsigned char)str[start]] == 0)
                count--;

            start++;
        }
    }

    return minLen;
}

int main() {
    char str[] = "abcda";

    printf("Length of smallest distinct window = %d\n", smallestDistinctWindow(str));

    return 0;
}
