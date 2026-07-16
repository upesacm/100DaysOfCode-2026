#include <stdio.h>
#include <string.h>

void removeDuplicates(char s[]) {
    char stack[100001];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {
        if (top != -1 && stack[top] == s[i]) {
            top--;              // Remove duplicate
        } else {
            stack[++top] = s[i]; // Push character
        }
    }

    stack[top + 1] = '\0';

    printf("Final string: %s\n", stack);
}

int main() {
    char s[100001];

    printf("Enter the string: ");
    scanf("%s", s);

    removeDuplicates(s);
    return 0;
}