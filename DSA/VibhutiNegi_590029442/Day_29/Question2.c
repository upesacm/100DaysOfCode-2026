#include <stdio.h>
#include <string.h>
void reverseString(char s[]) {
    int n = strlen(s);
    char stack[n];
    int top = -1;
    for (int i = 0; i < n; i++) {
        stack[++top] = s[i];
    }
    for (int i = 0; i < n; i++) {
        s[i] = stack[top--];
    }
}
int main() {
    char s[1000];
    scanf("%s", s);
    reverseString(s);
    printf("%s", s);
    return 0;
}