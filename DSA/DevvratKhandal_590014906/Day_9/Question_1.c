#include <stdio.h>
#include <string.h>
//Code for finding the length of the last word in a string
int main() {
    char s[100];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    int i = strlen(s) - 1;
    int count = 0;

    while (i >= 0 && (s[i] == ' ' || s[i] == '\n')) {
        i--;
    }

    while (i >= 0 && s[i] != ' ') {
        count++;
        i--;
    }

    printf("Length of last word = %d", count);

    return 0;
}