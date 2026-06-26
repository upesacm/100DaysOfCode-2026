#include <stdio.h>
#include <string.h>

int main() {
    char s[1000];

    fgets(s, sizeof(s), stdin);

    int len = strlen(s);

    if (s[len - 1] == '\n') {
        s[len - 1] = '\0';
        len--;
    }

    int left = 0;
    int right = len - 1;

    while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;
    }

    printf("%s", s);

    return 0;
}