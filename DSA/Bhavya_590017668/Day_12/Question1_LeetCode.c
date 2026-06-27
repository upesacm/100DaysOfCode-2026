

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
     int lines = 1;
    int currentWidth = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int charWidth = widths[s[i] - 'a'];

        if (currentWidth + charWidth > 100) {
            lines++;
            currentWidth = charWidth;
        } else {
            currentWidth += charWidth;
        }
    }

    int *result = (int*)malloc(2 * sizeof(int));
    result[0] = lines;
    result[1] = currentWidth;

    *returnSize = 2;
    return result;

}