#include <stdlib.h>

int* plusOne(int* digits, int digitsSize, int* returnSize) {

    // Traverse from the last digit
    for (int i = digitsSize - 1; i >= 0; i--) {

        // If digit is less than 9, increment and return
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }

        // If digit is 9, make it 0 and continue
        digits[i] = 0;
    }

    // If all digits were 9, create a new array
    int *result = (int *)malloc((digitsSize + 1) * sizeof(int));

    result[0] = 1;
    for (int i = 1; i <= digitsSize; i++) {
        result[i] = 0;
    }

    *returnSize = digitsSize + 1;
    return result;
}
