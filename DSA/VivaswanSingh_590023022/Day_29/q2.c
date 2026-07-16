#include <stdio.h>
#include <string.h>

int main()
{
    char s[1000];
    char stack[1000];
    int top = -1;

    scanf("%999s", s);

    for (int i = 0; s[i] != '\0'; i++)
    {
        stack[++top] = s[i];
    }

    while (top != -1)
    {
        printf("%c", stack[top--]);
    }

    return 0;
}