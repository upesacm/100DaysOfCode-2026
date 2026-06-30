#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestWindow(char str[])
{
    int n = strlen(str);
    int hash[256] = {0};
    int window[256] = {0};

    int distinct = 0;

    for (int i = 0; i < n; i++)
    {
        if (hash[(unsigned char)str[i]] == 0)
        {
            hash[(unsigned char)str[i]] = 1;
            distinct++;
        }
    }

    int left = 0;
    int count = 0;
    int minLength = INT_MAX;

    for (int right = 0; right < n; right++)
    {
        window[(unsigned char)str[right]]++;

        if (window[(unsigned char)str[right]] == 1)
            count++;

        while (count == distinct)
        {
            if (right - left + 1 < minLength)
                minLength = right - left + 1;

            window[(unsigned char)str[left]]--;

            if (window[(unsigned char)str[left]] == 0)
                count--;

            left++;
        }
    }

    return minLength;
}

int main()
{
    char str[1000];

    scanf("%s", str);

    printf("%d", smallestWindow(str));

    return 0;
}