#include <stdio.h>
#include <string.h>

int main() {
    char s[200], t[200];
    printf("Enter first string: ");
    scanf("%s", s);
    printf("Enter second string: ");
    scanf("%s", t);

    int i = strlen(s) - 1, j = strlen(t) - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) {

        while (i >= 0 && (s[i] == '#' || skipS > 0)) {
            if (s[i] == '#') skipS++;
            else skipS--;
            i--;
        }

        while (j >= 0 && (t[j] == '#' || skipT > 0)) {
            if (t[j] == '#') skipT++;
            else skipT--;
            j--;
        }

        if (i >= 0 && j >= 0 && s[i] != t[j]) {
            printf("false");
            return 0;
        }

        if ((i >= 0) != (j >= 0)) {
            printf("false");
            return 0;
        }

        i--;
        j--;
    }

    printf("true");
    return 0;
}
