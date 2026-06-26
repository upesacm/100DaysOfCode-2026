#include <stdio.h>
#include <ctype.h>
#include <string.h>

int isVowel(char ch) {
    ch = tolower(ch);
    return ch == 'a' || ch == 'e' || ch == 'i' ||
           ch == 'o' || ch == 'u';
}

int main() {
    char s[101];
    fgets(s, sizeof(s), stdin);

    for (int i = 0; s[i] != '\0' && s[i] != '\n'; i++) {
        if (!isVowel(s[i])) {
            printf(".%c", tolower(s[i]));
        }
    }

    return 0;
}