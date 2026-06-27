int* numberOfLines(int* widths, int widthsSize, char * s, int* returnSize){
    int* result = (int*)calloc((2), sizeof(int));
    result[0] = 1;
    
    for (int i = 0; s[i] != '\0'; i++) {
        int id = s[i] - 'a';
        if (result[1]+widths[id] > 100) {
            result[0]++;
            result[1] = widths[id];
        }
        else result[1] += widths[id];
    }
    *returnSize = 2;
    return result;
}