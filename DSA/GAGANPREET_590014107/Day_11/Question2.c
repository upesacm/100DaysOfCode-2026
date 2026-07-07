#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char s[101];
    scanf("%s", s);

    for (int i = 0; s[i] != '\0'; i++) {
        char ch = tolower(s[i]);

        if (ch != 'a' && ch != 'e' && ch != 'i' &&
            ch != 'o' && ch != 'u') {
            printf(".%c", ch);
        }
    }

    return 0;
}
