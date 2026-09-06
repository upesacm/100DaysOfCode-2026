#include <stdio.h>

int setBit(int mask, int pos) {
    return mask | (1 << pos);
}

int testBit(int mask, int pos) {
    return (mask & (1 << pos)) != 0;
}

int clearBit(int mask, int pos) {
    return mask & ~(1 << pos);
}

int toggleBit(int mask, int pos) {
    return mask ^ (1 << pos);
}

int countAwakened(int mask) {
    int count = 0;
    unsigned int value = (unsigned int)mask;

    while (value != 0) {
        count += value & 1;
        value >>= 1;
    }

    return count;
}

int main() {
    int mainframeMask = 0;

    mainframeMask = setBit(mainframeMask, 0);
    mainframeMask = setBit(mainframeMask, 3);
    mainframeMask = setBit(mainframeMask, 5);

    printf("%d\n", testBit(mainframeMask, 3));
    printf("%d\n", testBit(mainframeMask, 1));

    mainframeMask = clearBit(mainframeMask, 3);
    printf("%d\n", testBit(mainframeMask, 3));

    mainframeMask = toggleBit(mainframeMask, 5);
    printf("%d\n", testBit(mainframeMask, 5));

    printf("%d\n", countAwakened(mainframeMask));

    return 0;
}