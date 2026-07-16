#include <stdio.h>

void removeDuplicates(char s[]) {
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {
        if (top >= 0 && s[top] == s[i])
            top--;
        else
            s[++top] = s[i];
    }

    s[top + 1] = '\0';
}

int main() {
    char s[1000];

    printf("Enter a string: ");
    scanf("%s", s);

    removeDuplicates(s);

    printf("Resulting String: %s\n", s);

    return 0;
}