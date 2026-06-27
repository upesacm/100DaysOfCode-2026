#include <stdlib.h>
#include <string.h>

int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize) {
    int* result = (int*)malloc(2 * sizeof(int));

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

    result[0] = lines;
    result[1] = width;

    *returnSize = 2;
    return result;
}