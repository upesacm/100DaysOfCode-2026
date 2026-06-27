int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
    int *ans = (int *)malloc(2 * sizeof(int));
    int lines = 1;
    int current = 0;
    for(int i = 0; s[i] != '\0'; i++){
        int width = widths[s[i] - 'a'];
        if(current + width > 100){
            lines++;
            current = width;
        } else{
            current += width;
        }
    }
    ans[0] = lines;
    ans[1] = current;
    *returnSize = 2;
    return ans;
}