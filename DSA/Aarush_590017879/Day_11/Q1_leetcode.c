#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool isIsomorphic(char *s, char *t) {
    int mapST[256];
    int mapTS[256];

    for (int i = 0; i < 256; i++) {
        mapST[i] = -1;
        mapTS[i] = -1;
    }

    int n = strlen(s);

    for (int i = 0; i < n; i++) {
        unsigned char c1 = s[i];
        unsigned char c2 = t[i];

        if (mapST[c1] == -1 && mapTS[c2] == -1) {
            mapST[c1] = c2;
            mapTS[c2] = c1;
        } else {
            if (mapST[c1] != c2 || mapTS[c2] != c1)
                return false;
        }
    }

    return true;
}

int main() {
    char s[1001], t[1001];

    scanf("%s", s);
    scanf("%s", t);

    if (isIsomorphic(s, t))
        printf("true");
    else
        printf("false");

    return 0;
}