
int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize) {
    int lines = 1;
    int currentWidth = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];

        if (currentWidth + w > 100) {
            lines++;
            currentWidth = w;
        } else {
            currentWidth += w;
        }
    }

    int* result = (int*)malloc(2 * sizeof(int));
    result[0] = lines;
    result[1] = currentWidth;

    *returnSize = 2;
    return result;
}