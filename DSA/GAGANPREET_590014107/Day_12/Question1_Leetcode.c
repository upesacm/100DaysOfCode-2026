#include <stdio.h>

int main() {
    int widths[26];

    for (int i = 0; i < 26; i++)
        scanf("%d", &widths[i]);

    char s[1001];
    scanf("%s", s);

    int lines = 1;
    int lastWidth = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];

        if (lastWidth + w <= 100) {
            lastWidth += w;
        } else {
            lines++;
            lastWidth = w;
        }
    }

    printf("[%d, %d]", lines, lastWidth);

    return 0;
}