#include <stdio.h>

void removeSpaces(char *s) {
    int i = 0, j = 0;

    while (s[i] != '\0') {
        if (s[i] != ' ')
            s[j++] = s[i];
        i++;
    }
    s[j] = '\0';
}

int main() {
    char s[1000];
    fgets(s, sizeof(s), stdin);
    removeSpaces(s);
    printf("%s", s);
    return 0;
}