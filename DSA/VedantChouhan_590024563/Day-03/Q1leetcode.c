#include <stdio.h>

int main() {
    int digits[] = {1, 2, 3};
    int size = sizeof(digits) / sizeof(digits[0]);

    for(int i = size - 1; i >= 0; i--) {

        if(digits[i] < 9) {
            digits[i]++;
            break;
        }

        digits[i] = 0;
    }

    printf("Result: [");
    for(int i = 0; i < size; i++) {
        printf("%d", digits[i]);
        if(i < size - 1)
            printf(", ");
    }
    printf("]\n");

    return 0;
}