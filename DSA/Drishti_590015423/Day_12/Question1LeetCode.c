
#include <stdlib.h>

int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize) {
    int lines = 1;
    int currentWidth = 0;

    while (*s != '\0') {
        int w = widths[*s - 'a'];

        if (currentWidth + w <= 100) {
            currentWidth += w;
        } else {
            lines++;
            currentWidth = w;
        }

        s++;
    }

    int *result = (int *)malloc(2 * sizeof(int));
    result[0] = lines;
    result[1] = currentWidth;

    *returnSize = 2;
    return result;
}
