#include <stdlib.h>

int* numberOfLines(int* widths, int widthsSize, char *s, int* returnSize) {
    *returnSize = 2;

    int *result = (int *)malloc(2 * sizeof(int));

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

    return result;
}