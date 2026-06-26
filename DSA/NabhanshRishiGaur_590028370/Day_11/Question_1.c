#include <stdbool.h>
#include <string.h>

bool isIsomorphic(char* s, char* t) {
    int lastS[256] = {0};
    int lastT[256] = {0};

    int n = strlen(s);

    for (int i = 0; i < n; i++) {
        if (lastS[(unsigned char)s[i]] != lastT[(unsigned char)t[i]])
            return false;

        lastS[(unsigned char)s[i]] = i + 1;
        lastT[(unsigned char)t[i]] = i + 1;
    }

    return true;
}
