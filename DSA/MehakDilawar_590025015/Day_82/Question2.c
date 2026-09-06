//Write an efficient function that turns off the rightmost set bit of a positive integer using bit manipulation and returns the result.
//Input: n = 12. Output: 8.
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
