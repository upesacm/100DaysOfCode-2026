#include <stdio.h>
#include <ctype.h>

int main() {
    char s[101];

    printf("Enter a string: ");
    scanf("%s", s);

    for (int i = 0; s[i] != '\0'; i++) {

        char ch = tolower(s[i]);

        if (ch == 'a' || ch == 'e' || ch == 'i' ||
            ch == 'o' || ch == 'u' || ch == 'y') {
            continue;
        }

        printf(".%c", ch);
    }

    printf("\n");

    return 0;
}