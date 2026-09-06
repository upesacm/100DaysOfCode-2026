#include <stdio.h>
int turnOffRightmostSetBit(int n) {
    return n & (n - 1);
}
int main() {
    int n;
    scanf("%d", &n);
    printf("%d", turnOffRightmostSetBit(n));
    return 0;
}