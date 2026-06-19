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

    int *result = (int *)malloc((digitsSize + 1) * sizeof(int));

    result[0] = 1;

    for (int i = 1; i <= digitsSize; i++) {
        result[i] = 0;
    }

    *returnSize = digitsSize + 1;

    return result;
}

int main() {

    int digits[] = {9, 9, 9};
    int digitsSize = sizeof(digits) / sizeof(digits[0]);

    int returnSize;

    int *answer = plusOne(digits, digitsSize, &returnSize);

    printf("Result: ");

    for (int i = 0; i < returnSize; i++) {
        printf("%d ", answer[i]);
    }

    printf("\n");

    if (answer != digits) {
        free(answer);
    }

    return 0;
}