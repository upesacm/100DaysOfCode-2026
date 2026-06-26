#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isIsomorphic(char *s, char *t) {
    int n = strlen(s);

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if ((s[i] == s[j] && t[i] != t[j]) ||
                (s[i] != s[j] && t[i] == t[j])) {
                return false;
            }
        }
    }

    return true;
}

int main() {
    char s[] = "egg";
    char t[] = "add";

    if (isIsomorphic(s, t))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}