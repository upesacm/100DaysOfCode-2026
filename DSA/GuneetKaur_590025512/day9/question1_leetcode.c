#include <string.h>
#include <stdio.h>

int lengthOfLastWord(char *s) {
    int len = 0;
    int i = strlen(s) - 1;

    while (i >= 0 && s[i] == ' ')
        i--;

    while (i >= 0 && s[i] != ' ') {
        len++;
        i--;
    }

    return len;
}

int main() {
    char s[100];
    printf("Enter a string: ");
    scanf("%[^\n]", s);
    int result = lengthOfLastWord(s);
    printf("Length of  last word: %d\n", result);
    return 0;
}

