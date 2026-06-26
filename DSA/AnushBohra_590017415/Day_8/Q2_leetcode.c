#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool isPalindrome(char *s)
{
    int left = 0;
    int right = strlen(s) - 1;

    while (left < right)
    {
        while (left < right && !isalnum(s[left]))
            left++;

        while (left < right && !isalnum(s[right]))
            right--;

        if (tolower(s[left]) != tolower(s[right]))
            return false;

        left++;
        right--;
    }

    return true;
}

int main()
{
    char s1[] = "A man, a plan, a canal: Panama";
    char s2[] = "race a car";
    char s3[] = " ";

    printf("%s\n", isPalindrome(s1) ? "true" : "false");
    printf("%s\n", isPalindrome(s2) ? "true" : "false");
    printf("%s\n", isPalindrome(s3) ? "true" : "false");

    return 0;
}