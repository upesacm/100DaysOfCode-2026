#include <stdio.h>
#include <string.h>
int lengthOfLastWord(char *s) {
    int i = strlen(s) - 1;
    int count = 0;
    while (i >= 0 && s[i] == ' ') {
        i--;
    }
    while (i >= 0 && s[i] != ' ') {
        count++;
        i--;
    }
    return count;
}
