#include <stdio.h>
#include <string.h>

int main() {
    int widths[26];
    char s[1001];

    for (int i = 0; i < 26; i++) {
        scanf("%d", &widths[i]);
    }

    scanf("%s", s);

    int lines = 1;
    int width = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];

        if (width + w <= 100) {
            width += w;
        } else {
            lines++;
            width = w;
        }
    }

    printf("[%d,%d]\n", lines, width);

    return 0;
}