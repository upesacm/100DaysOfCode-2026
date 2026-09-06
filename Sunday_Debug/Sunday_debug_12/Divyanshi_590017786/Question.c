#include <stdio.h>

// Sets the bit at position pos
int setBit(int mask, int pos) {
    return mask | (1 << pos);
}

// Tests if the bit at position pos is set
int testBit(int mask, int pos) {
    return (mask & (1 << pos));
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

    for (int i = 0; i < 32; i++) {
        count += (mask >> i) & 1;
    }

    return count;
}

int main() {
    int mainframeMask = 0;

    mainframeMask = setBit(mainframeMask, 0); // Neo awakens
    mainframeMask = setBit(mainframeMask, 3); // Morpheus awakens
    mainframeMask = setBit(mainframeMask, 5); // Trinity awakens

    printf("%d\n", testBit(mainframeMask, 3) != 0);
    printf("%d\n", testBit(mainframeMask, 1) != 0);

    mainframeMask = clearBit(mainframeMask, 3); // Morpheus captured
    printf("%d\n", testBit(mainframeMask, 3) != 0);

    mainframeMask = toggleBit(mainframeMask, 5); // Smith overwrites Trinity's slot
    printf("%d\n", testBit(mainframeMask, 5) != 0);

    printf("%d\n", countAwakened(mainframeMask));

    return 0;
}