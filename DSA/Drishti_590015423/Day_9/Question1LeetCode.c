#include <string.h>

int lengthOfLastWord(char *s) {
    int i = strlen(s) - 1;
    int len = 0;

    // Skip trailing spaces
    while (i >= 0 && s[i] == ' ') {
        i--;
    }

    // Count characters in the last word
    while (i >= 0 && s[i] != ' ') {
        len++;
        i--;
    }

    return len;
}
