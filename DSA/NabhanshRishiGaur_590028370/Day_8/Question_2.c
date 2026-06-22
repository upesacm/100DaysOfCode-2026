#include <stdio.h>
#include <string.h>

int main() {
    char s[1001];

    scanf("%1000s", s);

    int left = 0;
    int right = strlen(s) - 1;

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
