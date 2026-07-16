#include <stdio.h>
#include <stdbool.h>

bool isValid(char s[]) {
    char stack[10000];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stack[++top] = s[i];
        } else {
            if (top == -1)
                return false;

            char ch = stack[top--];

            if ((s[i] == ')' && ch != '(') ||
                (s[i] == '}' && ch != '{') ||
                (s[i] == ']' && ch != '['))
                return false;
        }
    }

    return top == -1;
}

int main() {
    char s[1000];

    printf("Enter bracket string: ");
    scanf("%s", s);

    if (isValid(s))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}