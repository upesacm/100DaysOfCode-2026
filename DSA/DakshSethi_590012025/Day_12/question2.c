#include <stdio.h>
#include <string.h>

int findSubString(char *str) {
    int n = strlen(str);

    int distinct[256] = {0};
    int totalDistinct = 0;

    for (int i = 0; i < n; i++) {
        if (!distinct[(unsigned char)str[i]]) {
            distinct[(unsigned char)str[i]] = 1;
            totalDistinct++;
        }
    }

    int freq[256] = {0};
    int start = 0, count = 0;
    int minLen = n;

    for (int end = 0; end < n; end++) {
        freq[(unsigned char)str[end]]++;

        if (freq[(unsigned char)str[end]] == 1)
            count++;

        while (count == totalDistinct) {
            if (end - start + 1 < minLen)
                minLen = end - start + 1;

            freq[(unsigned char)str[start]]--;

            if (freq[(unsigned char)str[start]] == 0)
                count--;

            start++;
        }
    }

    return minLen;
}

int main() {
    char str[100005];
    scanf("%s", str);

    printf("%d\n", findSubString(str));

    return 0;
}