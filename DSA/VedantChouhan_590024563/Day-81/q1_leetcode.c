#include <stdio.h>

int hammingDistance(int x, int y) {
    int count = 0;

    // XOR gives 1 where bits are different
    int n = x ^ y;

    while (n != 0) {
        n = n & (n - 1);
        count++;
    }

    return count;
}

int main() {
    int x, y;

    printf("Enter x and y: ");
    scanf("%d %d", &x, &y);

    printf("Hamming Distance: %d\n", hammingDistance(x, y));

    return 0;
}