#include <stdio.h>
#include <string.h>
#include <limits.h>

int smallestDistinctWindow(char str[])
{
    int n = strlen(str);

    if (n == 0)
        return 0;

    int present[256] = {0};
    int window[256] = {0};

    int distinct = 0;

    for (int i = 0; i < n; i++) // this is to count distinct characters in the string
    {
        unsigned char ch = (unsigned char)str[i];

        if (!present[ch])
        {
            present[ch] = 1;
            distinct++;
        }
    }

    int left = 0;
    int formed = 0;
    int minLength = INT_MAX;

    for (int right = 0; right < n; right++)
    {
        unsigned char ch = (unsigned char)str[right];

        if (++window[ch] == 1)
            formed++;

        while (formed == distinct)
        {
            if (right - left + 1 < minLength)
                minLength = right - left + 1;

            unsigned char leftChar = (unsigned char)str[left];

            if (--window[leftChar] == 0)
                formed--;

            left++;
        }
    }

    return minLength;
}

int main()
{
    char str[1001];

    scanf("%1000s", str);

    printf("%d\n", smallestDistinctWindow(str));

    return 0;
}