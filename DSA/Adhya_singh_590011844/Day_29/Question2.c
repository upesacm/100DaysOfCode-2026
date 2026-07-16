#include <stdio.h>
#include <string.h>

void reverseString(char s[]) {
    char stack[1000];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++)
        stack[++top] = s[i];

    int index = 0;
    while (top != -1)
        s[index++] = stack[top--];

    s[index] = '\0';
}

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    int len = strlen(s);
    if (len > 0 && s[len - 1] == '\n')
        s[len - 1] = '\0';

    reverseString(s);

    printf("Reversed String: %s\n", s);

    return 0;
}