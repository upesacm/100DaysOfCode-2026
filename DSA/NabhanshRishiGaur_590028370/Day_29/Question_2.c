#include <stdio.h>
#include <string.h>

#define MAX 1000

char stack[MAX];
int top = -1;

void push(char ch) {
    stack[++top] = ch;
}

char pop() {
    return stack[top--];
}

int main() {
    char s[MAX];

    scanf("%s", s);

    int n = strlen(s);

    for (int i = 0; i < n; i++) {
        push(s[i]);
    }

    for (int i = 0; i < n; i++) {
        s[i] = pop();
    }

    printf("%s", s);

    return 0;
}
