#include <stdio.h>

void removeSpaces(char* s) {
    int i, j = 0;
    for (i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ')
            s[j++] = s[i];
    }
    s[j] = '\0';
}

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';

    printf("Original string : %s\n", s);
    removeSpaces(s);
    printf("Modified string : %s\n", s);

    return 0;
}
