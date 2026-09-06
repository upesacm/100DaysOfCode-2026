
#include <stdio.h>

// Sets the bit at position pos
int setBit(int mask, int pos) {
    return mask | (1 << pos);
}

// Tests if the bit at position pos is set
int testBit(int mask, int pos) {
    return (mask & (1 << pos)) != 0;
}

// Clears the bit at position pos
int clearBit(int mask, int pos) {
    return mask & ~(1 << pos);
}

// Toggles the bit at position pos
int toggleBit(int mask, int pos) {
    return mask ^ (1 << pos);
}

// Counts number of set bits in mask
int countAwakened(int mask) {
    int count = 0;

    while (mask != 0) {
        count += mask & 1;
        mask >>= 1;
    }

    return count;
}

int main() {
    int mainframeMask = 0;

    mainframeMask = setBit(mainframeMask, 0);
    mainframeMask = setBit(mainframeMask, 3);
    mainframeMask = setBit(mainframeMask, 5);

    printf("%d\n", testBit(mainframeMask, 3) != 0);
    printf("%d\n", testBit(mainframeMask, 1) != 0);

    mainframeMask = clearBit(mainframeMask, 3);
    printf("%d\n", testBit(mainframeMask, 3) != 0);

    mainframeMask = toggleBit(mainframeMask, 5);
    printf("%d\n", testBit(mainframeMask, 5) != 0);

    printf("%d\n", countAwakened(mainframeMask));

    return 0;
}