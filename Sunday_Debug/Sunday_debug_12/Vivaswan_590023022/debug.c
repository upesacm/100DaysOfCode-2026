#include <stdio.h>

// Sets the bit at position pos
int setBit(int mask, int pos)
{
    return (int)((unsigned int)mask | (1u << pos));
}

// Tests if the bit at position pos is set
int testBit(int mask, int pos)
{
    return ((unsigned int)mask & (1u << pos)) != 0;
}

// Clears the bit at position pos
int clearBit(int mask, int pos)
{
    return (int)((unsigned int)mask & ~(1u << pos));
}

// Toggles the bit at position pos
int toggleBit(int mask, int pos)
{
    return (int)((unsigned int)mask ^ (1u << pos));
}

// Counts number of set bits in mask
int countAwakened(int mask)
{
    int count = 0;
    unsigned int value = (unsigned int)mask;

    while (value != 0)
    {
        count += value & 1u;
        value >>= 1;
    }

    return count;
}

int main()
{
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