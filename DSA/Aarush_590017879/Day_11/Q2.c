#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char ch) {
    ch = tolower(ch);
    return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
}

int main() {
    char str[101];
    scanf("%s", str);

    for (int i = 0; str[i] != '\0'; i++) {
        if (!isVowel(str[i])) {
            printf(".%c", tolower(str[i]));
        }
    }

    return 0;
}