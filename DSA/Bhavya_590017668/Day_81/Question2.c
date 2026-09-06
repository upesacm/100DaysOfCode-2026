#include <stdio.h>
int turnOffRightmostSetBit(int n) {
    return n & (n - 1);
}