#include <stdio.h>
#include <string.h>

int main()
{
    char str[100];
    char stack[100];
    int top = -1;

    printf("Enter a string: ");
    scanf("%s", str);

    // Push all characters onto the stack
    for (int i = 0; i < strlen(str); i++)
    {
        stack[++top] = str[i];
    }

    // Pop and print characters
    printf("Reversed String: ");

    while (top != -1)
    {
        printf("%c", stack[top]);
        top--;
    }

    printf("\n");

    return 0;
}