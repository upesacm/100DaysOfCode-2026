// This function takes an array of digits representing a non-negative integer and adds one to that integer. The input parameters are:
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;   
        }
        digits[i] = 0;       
    }
    int* result = (int*)calloc(digitsSize + 1, sizeof(int));
    result[0] = 1;           
    *returnSize = digitsSize + 1;
    return result;
}