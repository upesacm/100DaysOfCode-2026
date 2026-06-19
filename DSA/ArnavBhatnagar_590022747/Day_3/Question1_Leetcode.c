#include <stdio.h>
#include <stdlib.h>

int* plusOne(int* digits, int digitsSize, int* returnSize) {
    for (int i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        digits[i] = 0;
    }

    int* result = (int*)malloc((digitsSize + 1) * sizeof(int));

    result[0] = 1;
    for (int i = 1; i <= digitsSize; i++) {
        result[i] = 0;
    }

    *returnSize = digitsSize + 1;
    return result;
}

int main() {
    int n;

    printf("Enter number of digits: ");
    scanf("%d", &n);

    int* digits = (int*)malloc(n * sizeof(int));

    printf("Enter digits: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &digits[i]);
    }

    int returnSize;
    int* result = plusOne(digits, n, &returnSize);

    printf("Result: ");
    for (int i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }

    printf("\n");

    if (result != digits)
        free(result);

    free(digits);

    return 0;
}