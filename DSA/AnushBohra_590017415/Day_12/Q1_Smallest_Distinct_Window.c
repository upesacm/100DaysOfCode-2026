#include <stdio.h>
#include <string.h>
#include <limits.h>

int shortestSubstring(char str[])
{
    int freq[256] = {0};
    int window[256] = {0};

    int distinct = 0;

    // Count distinct characters
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (freq[(unsigned char)str[i]] == 0)
        {
            freq[(unsigned char)str[i]] = 1;
            distinct++;
        }
    }

    int left = 0, count = 0;
    int minLen = INT_MAX;

    for (int right = 0; str[right] != '\0'; right++)
    {
        window[(unsigned char)str[right]]++;

        if (window[(unsigned char)str[right]] == 1)
            count++;

        while (count == distinct)
        {
            if (right - left + 1 < minLen)
                minLen = right - left + 1;

            window[(unsigned char)str[left]]--;

            if (window[(unsigned char)str[left]] == 0)
                count--;

            left++;
        }
    }

    return minLen;
}

int main()
{
    char str[100];

    printf("Enter string: ");
    scanf("%s", str);

    printf("%d\n", shortestSubstring(str));

    return 0;
}