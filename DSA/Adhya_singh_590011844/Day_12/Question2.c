#include <stdio.h>
#include <string.h>

int main() {
    char str[1001];
    int freq[256] = {0};
    int window[256] = {0};

    scanf("%s", str);

    int distinct = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        if (freq[(unsigned char)str[i]] == 0)
            distinct++;
        freq[(unsigned char)str[i]]++;
    }

    int start = 0, count = 0;
    int minLen = strlen(str);

    for (int end = 0; str[end] != '\0'; end++) {
        window[(unsigned char)str[end]]++;

        if (window[(unsigned char)str[end]] == 1)
            count++;

        while (count == distinct) {
            if (end - start + 1 < minLen)
                minLen = end - start + 1;

            window[(unsigned char)str[start]]--;

            if (window[(unsigned char)str[start]] == 0)
                count--;

            start++;
        }
    }

    printf("%d\n", minLen);

    return 0;
}