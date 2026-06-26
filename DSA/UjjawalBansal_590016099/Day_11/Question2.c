#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

void str_opr(const char* s, char* result) {
    int j = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        char c = tolower((unsigned char)s[i]);
        
        if (!isVowel(c)) {
            result[j++] = '.';
            result[j++] = c;
        }
    }
    result[j] = '\0';
}

int main() {
    char s[1000];
    char ans[2000];

    printf("Enter a string: ");
    if (fgets(s, sizeof(s), stdin)) {
        s[strcspn(s, "\r\n")] = '\0';

        str_opr(s, ans);
        printf("Transformed String: %s\n", ans);
    }
    return 0;
}