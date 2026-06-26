#include <stdio.h>
int main() {
    char str[1000];
    fgets(str, sizeof(str), stdin);

    int i, j = 0;

    for (i = 0; str[i] != '\0'; i++) {
        if (str[i] != ' ' && str[i] != '\n') {
            str[j++] = str[i];
        }
    }

    str[j] = '\0';

    printf("%s", str);

    return 0;
}