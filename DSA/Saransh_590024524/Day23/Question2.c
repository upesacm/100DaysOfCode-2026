#include <string.h>
#include <stdbool.h>

bool backspaceCompare(char *s, char *t) {
    int i = strlen(s) - 1, j = strlen(t) - 1;

    while (i >= 0 || j >= 0) {
        int skipS = 0, skipT = 0;

        while (i >= 0 && (s[i] == '#' || skipS)) {
            if (s[i] == '#') skipS++;
            else skipS--;
            i--;
        }

        while (j >= 0 && (t[j] == '#' || skipT)) {
            if (t[j] == '#') skipT++;
            else skipT--;
            j--;
        }

        if (i >= 0 && j >= 0) {
            if (s[i] != t[j]) return false;
        }
        else if (i >= 0 || j >= 0) {
            return false;
        }

        i--;
        j--;
    }

    return true;
}