#include <stdio.h>
#include <stdlib.h>

int* plusOne(int* digits, int digitsSize, int* returnSize) {
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            int* arr = (int*)malloc(digitsSize * sizeof(int));
            for (int j = 0; j < digitsSize; j++) {
                arr[j] = digits[j];
            }
            *returnSize = digitsSize;
            return arr;
        }
        digits[i] = 0;
    }
    
    int size = digitsSize + 1;
    int* arr = (int*)malloc(size * sizeof(int));
    arr[0] = 1;
    for (int j = 1; j < size; j++) {
        arr[j] = 0;
    }
    *returnSize = size;
    return arr;
}