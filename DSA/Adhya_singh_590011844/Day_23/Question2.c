#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool backspaceCompare(char *s, char *t) {
    int i = strlen(s) - 1;
    int j = strlen(t) - 1;

    while (i >= 0 || j >= 0) {
        int skipS = 0, skipT = 0;

        while (i >= 0) {
            if (s[i] == '#') {
                skipS++;
                i--;
            } else if (skipS > 0) {
                skipS--;
                i--;
            } else {
                break;
            }
        }

        while (j >= 0) {
            if (t[j] == '#') {
                skipT++;
                j--;
            } else if (skipT > 0) {
                skipT--;
                j--;
            } else {
                break;
            }
        }

        if (i >= 0 && j >= 0) {
            if (s[i] != t[j])
                return false;
        } else if (i >= 0 || j >= 0) {
            return false;
        }

        i--;
        j--;
    }

    return true;
}

int main() {
    char s[1000], t[1000];

    printf("Enter first string: ");
    scanf("%s", s);

    printf("Enter second string: ");
    scanf("%s", t);

    if (backspaceCompare(s, t))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}