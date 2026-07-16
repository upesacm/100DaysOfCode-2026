/* Reverse the given string using a stack and print the reversed string.

Example:
Input:s = hello;  Output:olleh   */


#include <stdio.h>
#define MAX 100
int top=-1;

char stack[MAX];

void push(char c)
{
    if (top == MAX-1)
    {
        printf("stack overflow.\n");
    }
    stack[++top] = c;
}


char pop()
{
    if (top == -1)
    {
        printf("stack underflow.");
        return '\0';
    }

    else
    {
        char c = stack[top];
        top--;
        return c;
    }
}


int main()
{
    char s[100]; int i=0;

    printf("enter the string: ");
    scanf ("%s", s);

    while (s[i] != '\0')
    {
        push(s[i]);
        i++;
    }


    while (top != -1)
    {
        printf("%c", pop());
    }

    return 0;
}