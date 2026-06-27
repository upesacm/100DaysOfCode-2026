#include <stdio.h>
#include <string.h>

int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize) {
    static int result[2];

    int lines = 1;
    int currentWidth = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];

        if (currentWidth + w <= 100) {
            currentWidth += w;
        } else {
            lines++;
            currentWidth = w;
        }
    }

    result[0] = lines;
    result[1] = currentWidth;

    *returnSize = 2;
    return result;
}

int main() {
    int widths[26] = {
        10,10,10,10,10,10,10,10,10,10,
        10,10,10,10,10,10,10,10,10,10,
        10,10,10,10,10,10
    };

    char s[] = "abcdefghijklmnopqrstuvwxyz";

    int returnSize;
    int *ans = numberOfLines(widths, 26, s, &returnSize);

    printf("[%d, %d]\n", ans[0], ans[1]);

    return 0;
}
