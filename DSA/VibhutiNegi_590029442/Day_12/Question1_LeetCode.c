int* numberOfLines(int* widths, int widthsSize, char *s, int* returnSize) {
    int *ans = (int *)malloc(2 * sizeof(int));
    int lines = 1;
    int currWidth = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        int w = widths[s[i] - 'a'];
        if (currWidth + w > 100) {
            lines++;
            currWidth = w;
        } else {
            currWidth += w;
        }
    }
    ans[0] = lines;
    ans[1] = currWidth;
    *returnSize = 2;
    return ans;
}