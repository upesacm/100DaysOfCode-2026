#include <stdio.h>
#include <string.h>

void reverseString(char* s) {
    int n = strlen(s);
    char stack[n];
    int top = -1;

    // push all characters onto stack
    for (int i = 0; i < n; i++)
        stack[++top] = s[i];

    // pop all characters back into string
    for (int i = 0; i < n; i++)
        s[i] = stack[top--];
}

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';

    printf("Original string : %s\n", s);
    reverseString(s);
    printf("Reversed string : %s\n", s);

    return 0;
}
