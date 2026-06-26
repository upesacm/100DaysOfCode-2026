#include <stdio.h>
#include <string.h>
void removeSpaces(char *s) {
    int i, j = 0;
    for (i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ') {
            s[j] = s[i];
            j++;
        }
    }

    s[j] = '\0';
}
int main() {
    char s[200];
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';
    removeSpaces(s);
    printf("%s\n", s);
    return 0;
}
