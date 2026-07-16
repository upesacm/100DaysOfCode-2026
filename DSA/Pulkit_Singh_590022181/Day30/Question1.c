#include <stdio.h>
#include <string.h>

void removeDuplicates(char str[]) {

    char stack[1000];
    int top = -1;

    for (int i = 0; str[i] != '\0'; i++) {

        if (top != -1 && stack[top] == str[i]) {
            top--;
        }
        else {
            stack[++top] = str[i];
        }
    }

    stack[top + 1] = '\0';

    printf("Result: %s\n", stack);
}

int main() {

    char str[] = "abbaca";

    removeDuplicates(str);

    return 0;
}