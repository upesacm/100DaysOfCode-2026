#include <stdio.h>
#include <string.h>

int minLength(char s[]) {

    char stack[1000];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {

        if (top != -1 &&
            ((stack[top] == 'A' && s[i] == 'B') ||
             (stack[top] == 'C' && s[i] == 'D'))) {

            top--;
        }
        else {
            stack[++top] = s[i];
        }
    }

    return top + 1;
}

int main() {

    char s[1000];

    printf("Enter string: ");
    scanf("%s", s);

    printf("Minimum Length: %d\n", minLength(s));

    return 0;
}