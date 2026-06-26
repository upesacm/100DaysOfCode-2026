#include <stdio.h>
#include <string.h>

void reverseString(char *s) {
    int l = 0, r = strlen(s) - 1;

    while (l < r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        l++;
        r--;
    }
}

int main() {
    char s[1000];
    scanf("%999s", s);

    reverseString(s);

    printf("%s\n", s);
    return 0;
}