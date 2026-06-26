#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main() {
    char s[1000];
    fgets(s, sizeof(s), stdin);

    int left = 0;
    int right = strlen(s) - 1;

    while (left < right) {
        while (left < right && !isalnum(s[left]))
            left++;

        while (left < right && !isalnum(s[right]))
            right--;

        if (tolower(s[left]) != tolower(s[right])) {
            printf("false");
            return 0;
        }

        left++;
        right--;
    }

    printf("true");
    return 0;
}