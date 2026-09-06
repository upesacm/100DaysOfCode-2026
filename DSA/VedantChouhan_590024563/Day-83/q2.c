#include <stdio.h>

int countSetBits(int n) {
    int count = 0;

    while (n != 0) {
        // Turn off the rightmost set bit
        n = n & (n - 1);
        count++;
    }

    return count;
}

int main() {
    int n;

    printf("Enter a non-negative integer: ");
    scanf("%d", &n);

    printf("Number of set bits: %d\n", countSetBits(n));

    return 0;
}