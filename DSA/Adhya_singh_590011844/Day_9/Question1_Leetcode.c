#include <stdio.h>
#include <string.h>

int lengthOfLastWord(char *s) {
    int i = strlen(s) - 1;
    int len = 0;

    while (i >= 0 && s[i] == ' ')
        i--;

    
    while (i >= 0 && s[i] != ' ') {
        len++;
        i--;
    }

    return len;
}

int main() {
    char s[1000];

    fgets(s, sizeof(s), stdin);

    int n = strlen(s);
    if (n > 0 && s[n - 1] == '\n')
        s[n - 1] = '\0';

    printf("%d\n", lengthOfLastWord(s));

    return 0;
}