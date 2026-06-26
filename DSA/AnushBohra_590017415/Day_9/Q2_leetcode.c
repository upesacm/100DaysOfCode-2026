#include <stdio.h>
#include <string.h>

int lengthOfLastWord(char* s)
{
    int i = strlen(s) - 1;
    int count = 0;

    while (i >= 0 && s[i] == ' ')
    {
        i--;
    }

    while (i >= 0 && s[i] != ' ')
    {
        count++;
        i--;
    }

    return count;
}

int main()
{
    char s1[] = "Hello World";
    char s2[] = "   fly me   to   the moon  ";
    char s3[] = "luffy is still joyboy";

    printf("%d\n", lengthOfLastWord(s1));
    printf("%d\n", lengthOfLastWord(s2));
    printf("%d\n", lengthOfLastWord(s3));

    return 0;
}