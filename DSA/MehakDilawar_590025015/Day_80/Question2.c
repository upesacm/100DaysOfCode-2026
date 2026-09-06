//Write an efficient function that determines whether a non-negative integer is either 0 or a power of two, using bit manipulation.
//Input: n = 0. Output: true.
#include <stdio.h>
int isPowerOfTwoOrZero(int n) {
    return n == 0 || (n > 0 && (n & (n - 1)) == 0);
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
