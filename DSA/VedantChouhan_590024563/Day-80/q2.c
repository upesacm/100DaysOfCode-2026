#include <stdio.h>

int isPowerOfTwoOrZero(int n) {
    // 0 is also considered valid
    if (n == 0)
        return 1;

    // Power of 2 has exactly one set bit
    return (n & (n - 1)) == 0;
}

int main() {
    int n;

    printf("Enter a non-negative integer: ");
    scanf("%d", &n);

    if (isPowerOfTwoOrZero(n))
        printf("true\n");
    else
        printf("false\n");

    return 0;
}