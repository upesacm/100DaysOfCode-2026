#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main() {
    char s[1000], t[1000];

    printf("Enter first string: ");
    scanf("%s", s);

    printf("Enter second string: ");
    scanf("%s", t);

    if (strlen(s) != strlen(t)) {
        printf("false\n");
        return 0;
    }

    int mapST[256];
    int mapTS[256];

    for (int i = 0; i < 256; i++) {
        mapST[i] = -1;
        mapTS[i] = -1;
    }

    for (int i = 0; s[i] != '\0'; i++) {

        if (mapST[(unsigned char)s[i]] == -1 &&
            mapTS[(unsigned char)t[i]] == -1) {

            mapST[(unsigned char)s[i]] = t[i];
            mapTS[(unsigned char)t[i]] = s[i];
        }
        else if (mapST[(unsigned char)s[i]] != t[i] ||
                 mapTS[(unsigned char)t[i]] != s[i]) {

            printf("false\n");
            return 0;
        }
    }

    printf("true\n");

    return 0;
}