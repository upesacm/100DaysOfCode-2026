#include <stdio.h>

int isPowerOfTwoOrZero(int n) {
    return n == 0 || (n > 0 && (n & (n - 1)) == 0);
}