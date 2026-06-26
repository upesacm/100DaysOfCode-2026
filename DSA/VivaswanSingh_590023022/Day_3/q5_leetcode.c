int* plusOne(int* digits, int digitsSize, int* returnSize) {
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            
            int* result = (int*)malloc(digitsSize * sizeof(int));
            for (int j = 0; j < digitsSize; j++) {
                result[j] = digits[j];
            }
            return result;
        }
        
        digits[i] = 0;
    }
    
    *returnSize = digitsSize + 1;
    int* result = (int*)malloc((*returnSize) * sizeof(int));
    
        result[0] = 1;
    for (int i = 1; i < *returnSize; i++) {
        result[i] = 0;
    }
    
    return result;
}