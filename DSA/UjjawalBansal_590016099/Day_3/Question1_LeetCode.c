int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int done = 0;
    for (int i = digitsSize-1; i >= 0; i--) {
        if (digits[i] != 9) {
            digits[i]++;
            done = 1;
            break;
        }
        else {
            digits[i] = 0;
        }
    }
    if (!done) {
        int* ans = (int*)calloc((digitsSize+1), sizeof(int));
        ans[0] = 1;
        *returnSize = digitsSize+1;
        return ans;
    }
    else {
        *returnSize = digitsSize;
        return digits;
    }
}