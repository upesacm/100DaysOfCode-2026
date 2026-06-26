#include <stdio.h>
#include <stdlib.h>

int* plusOne(int* digits, int digitsSize, int* returnSize) {
    int i;

    // Traverse from the last digit
    for (i = digitsSize - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        digits[i] = 0;
    }

    // If all digits were 9
    int* result = (int*)malloc((digitsSize + 1) * sizeof(int));
    result[0] = 1;

    for (i = 1; i <= digitsSize; i++) {
        result[i] = 0;
    }

    *returnSize = digitsSize + 1;
    return result;
}

int main() {
    int digits[100], n, i;
    int returnSize;

    printf("Enter number of digits: ");
    scanf("%d", &n);

    printf("Enter digits: ");
    for (i = 0; i < n; i++) {
        scanf("%d", &digits[i]);
    }

    int* result = plusOne(digits, n, &returnSize);

    printf("Result: ");
    for (i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }

    printf("\n");

    return 0;
}