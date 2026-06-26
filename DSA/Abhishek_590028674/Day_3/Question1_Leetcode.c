/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i = digitsSize-1;
    while(i>=0 && digits[i]==9){
        digits[i] = 0;
        i--;
    };
    if(i+1){
        digits[i]++;
        *returnSize = digitsSize;
    }
    else{
        digits = realloc(digits, sizeof(int)*(digitsSize+1));
        digits[0] = 1;
        digits[digitsSize] = 0;
        *returnSize = ++digitsSize;
    }
    return(digits);
}