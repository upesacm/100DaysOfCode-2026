#include <stdio.h>
#include <string.h>

void removeDuplicates(char s[]) {

    char stack[1000];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {

        if (top != -1 && stack[top] == s[i]) {
            top--;
        } else {
            stack[++top] = s[i];
        }
    }

    int index = 0;

    for (int i = 0; i <= top; i++) {
        s[index++] = stack[i];
    }

    s[index] = '\0';
}

int main() {

    char s[1000];

    printf("Enter string: ");
    scanf("%s", s);

    removeDuplicates(s);

    printf("Result: %s\n", s);

    return 0;
}