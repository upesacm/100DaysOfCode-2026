#include <stdio.h>
#include <string.h>
#include <limits.h>

int findSubString(char str[])
{
    int n = strlen(str);

    // Count total distinct characters
    int visited[256] = {0};
    int distinct = 0;

    for (int i = 0; i < n; i++)
    {
        if (visited[(unsigned char)str[i]] == 0)
        {
            visited[(unsigned char)str[i]] = 1;
            distinct++;
        }
    }

    // Sliding window
    int freq[256] = {0};
    int start = 0;
    int count = 0;
    int minLen = INT_MAX;

    for (int end = 0; end < n; end++)
    {
        freq[(unsigned char)str[end]]++;

        if (freq[(unsigned char)str[end]] == 1)
            count++;

        while (count == distinct)
        {
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

int main()
{
    char str[] = "aabcbcdbca";

    printf("%d", findSubString(str));

    return 0;
}