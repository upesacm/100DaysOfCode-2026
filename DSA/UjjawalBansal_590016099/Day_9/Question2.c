#include <stdio.h>
#include <string.h>

void rm_spaces(char* s) {
    int w = 0;
    for (int r = 0; s[r] != '\0'; r++){
        if (s[r] != ' ') s[w++] = s[r];
    }
    s[w] = '\0';
}

int main() {
    char s[1000];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\r\n")] = '\0';

    rm_spaces(s);
    printf("String without spaces: %s", s);
}