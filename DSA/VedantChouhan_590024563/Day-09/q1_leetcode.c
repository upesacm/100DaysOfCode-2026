#include <stdio.h>
#include <string.h>

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    int len = strlen(s);

    // Remove newline character if present
    if (len > 0 && s[len - 1] == '\n') {
        s[len - 1] = '\0';
        len--;
    }

    int i = len - 1;

    // Skip trailing spaces
    while (i >= 0 && s[i] == ' ') {
        i--;
    }

    int count = 0;

    // Count characters of the last word
    while (i >= 0 && s[i] != ' ') {
        count++;
        i--;
    }

    printf("Length of last word: %d\n", count);

    return 0;
}