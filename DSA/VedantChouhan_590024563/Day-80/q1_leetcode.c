#include <stdio.h>

int hammingWeight(int n) {
    int count = 0;

    while (n != 0) {
        n = n & (n - 1);
        count++;
    }

    return count;
}

int main() {
    int n;

    printf("Enter a positive integer: ");
    scanf("%d", &n);

    printf("Number of set bits: %d\n", hammingWeight(n));

    return 0;
}