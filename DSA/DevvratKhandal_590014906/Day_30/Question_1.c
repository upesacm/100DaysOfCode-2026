#include <stdio.h>
#include <string.h>

int main() {
    char s[1000];
    char stack[1000];
    int top = -1;

    printf("Enter the string: ");
    scanf("%s", s);

    for(int i = 0; s[i] != '\0'; i++) {
        if(top != -1 && stack[top] == s[i]) {
            top--;      // remove duplicate
        }
        else {
            stack[++top] = s[i];
        }
    }

    stack[top + 1] = '\0';

    printf("Final string: %s\n", stack);

    return 0;
}