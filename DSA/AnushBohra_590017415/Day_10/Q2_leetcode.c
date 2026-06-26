#include <stdio.h>

int strStr(char* haystack, char* needle)
{
    int i, j;

    for (i = 0; haystack[i] != '\0'; i++)
    {
        j = 0;

        while (needle[j] != '\0' &&
               haystack[i + j] == needle[j])
        {
            j++;
        }

        if (needle[j] == '\0')
        {
            return i;
        }
    }

    return -1;
}

int main()
{
    char haystack[] = "sadbutsad";
    char needle[] = "sad";

    printf("%d\n", strStr(haystack, needle));

    return 0;
}