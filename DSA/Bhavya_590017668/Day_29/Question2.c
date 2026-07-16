#include <stdio.h>
#include <string.h>

#define MAX 100

int main() {
    char s[MAX];
    char stack[MAX];
    int top = -1;

    scanf("%s", s);

    // Push characters onto the stack
    for (int i = 0; s[i] != '\0'; i++) {
        stack[++top] = s[i];
    }

    // Pop characters to print the reversed string
    while (top != -1) {
        printf("%c", stack[top--]);
    }

    return 0;
}