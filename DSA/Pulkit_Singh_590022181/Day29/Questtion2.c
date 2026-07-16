#include <stdio.h>
#include <string.h>

#define MAX 100

char stack[MAX];
int top = -1;

// Push operation
void push(char ch) {
    if (top < MAX - 1)
        stack[++top] = ch;
}

// Pop operation
char pop() {
    if (top >= 0)
        return stack[top--];
    return '\0';
}

int main() {

    char str[MAX];

    printf("Enter a string: ");
    scanf("%s", str);

    // Push all characters onto the stack
    for (int i = 0; i < strlen(str); i++) {
        push(str[i]);
    }

    printf("Reversed String: ");

    // Pop all characters from the stack
    while (top != -1) {
        printf("%c", pop());
    }

    printf("\n");

    return 0;
}