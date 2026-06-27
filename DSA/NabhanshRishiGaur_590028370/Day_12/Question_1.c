int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize) {
    int *res = (int *)malloc(2 * sizeof(int));

    int lines = 1;
    int remaining = 100;

    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];

        if (w <= remaining) {
            remaining -= w;
        } else {
            lines++;
            remaining = 100 - w;
        }
    }

    res[0] = lines;
    res[1] = 100 - remaining;
    *returnSize = 2;

    return res;
}
