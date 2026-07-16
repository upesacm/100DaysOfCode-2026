#include <stdio.h>
#include <string.h>

#define MAX 100

char stack[MAX];
int top = -1;

void push(char ch) {
    if (top < MAX - 1)
        stack[++top] = ch;
}

char pop() {
    if (top >= 0)
        return stack[top--];
    return '\0';
}

int main() {

    char str[MAX];

    printf("Enter a string: ");
    scanf("%s", str);

    int len = strlen(str);

    // Push all characters
    for (int i = 0; i < len; i++)
        push(str[i]);

    printf("Reversed String: ");

    // Pop all characters
    while (top != -1)
        printf("%c", pop());

    printf("\n");

    return 0;
}