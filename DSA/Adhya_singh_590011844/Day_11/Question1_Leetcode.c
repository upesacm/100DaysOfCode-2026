#include <stdbool.h>

bool isIsomorphic(char* s, char* t) {
    int mapST[256];
    int mapTS[256];

    for (int i = 0; i < 256; i++) {
        mapST[i] = -1;
        mapTS[i] = -1;
    }

    while (*s && *t) {
        unsigned char c1 = *s;
        unsigned char c2 = *t;

        if (mapST[c1] == -1 && mapTS[c2] == -1) {
            mapST[c1] = c2;
            mapTS[c2] = c1;
        } else if (mapST[c1] != c2 || mapTS[c2] != c1) {
            return false;
        }

        s++;
        t++;
    }
    return *s == '\0' && *t == '\0';
}