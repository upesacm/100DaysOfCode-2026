#include <stdio.h>

int turnOffRightmostSetBit(int n) {
    return n & (n - 1);
}

int main() {
    int n;

    printf("Enter a positive integer: ");
    scanf("%d", &n);

    printf("Result: %d\n", turnOffRightmostSetBit(n));

    return 0;
}