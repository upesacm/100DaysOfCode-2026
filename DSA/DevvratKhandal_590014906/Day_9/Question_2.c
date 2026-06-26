#include <stdio.h>
#include <string.h>
//Code for removing spaces from a string
int main() {
    char s[100], result[100];
    int j = 0;

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ' && s[i] != '\n') {
            result[j] = s[i];
            j++;
        }
    }

    result[j] = '\0';

    printf("String without spaces: %s", result);

    return 0;
}