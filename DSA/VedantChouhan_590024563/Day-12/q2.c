#include <stdio.h>
#include <string.h>
#include <limits.h>

int main() {
    char str[1000];

    printf("Enter the string: ");
    scanf("%s", str);

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
    int left = 0, count = 0;
    int minLen = INT_MAX;

    for (int right = 0; right < n; right++) {

        freq[(unsigned char)str[right]]++;

        if (freq[(unsigned char)str[right]] == 1)
            count++;

        while (count == distinct) {

            if (right - left + 1 < minLen)
                minLen = right - left + 1;

            freq[(unsigned char)str[left]]--;

            if (freq[(unsigned char)str[left]] == 0)
                count--;

            left++;
        }
    }

    printf("Length of smallest substring: %d\n", minLen);

    return 0;
}