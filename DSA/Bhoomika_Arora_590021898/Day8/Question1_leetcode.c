#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

bool isPalindrome(char *s) {
    int l = 0, r = strlen(s) - 1;

    while (l < r) {
        while (l < r && !isalnum(s[l])) l++;
        while (l < r && !isalnum(s[r])) r--;

        if (tolower(s[l]) != tolower(s[r]))
            return false;

        l++;
        r--;
    }
    return true;
}

int main() {
    char s[1000];
    fgets(s, sizeof(s), stdin);

    printf(isPalindrome(s) ? "true\n" : "false\n");
    return 0;
}