#include <stdio.h>
#include <string.h>

int main() 
{
    char str[1000];
    char str2[1000];

    if (fgets(str, sizeof(str), stdin) == NULL)
        return 0;

    int len = strlen(str);
    if (len > 0 && str[len - 1] == '\n') {
        str[len - 1] = '\0';
        len--;
    }

    for (int i = len - 1; i >= 0; i--)
    {
        str2[len - 1 - i] = str[i];
    }
    str2[len] = '\0';
    if (strcmp(str, str2) == 0)
        printf("\nThe string is a palindrome.");
    else
        printf("\nThe string is not a palindrome.");

    return 0;
}