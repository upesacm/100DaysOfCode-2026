//Write an efficient function to count the number of set bits (1s) in the binary representation of a non-negative integer 
//using bit manipulation.
//Input: 13. Output: 3
#include <stdio.h>
int countSetBits(unsigned int n) {
    int count = 0;
    while (n) {
        n = n & (n - 1);
        count++;
    }
    return count;
}

int main() {
    unsigned int n;
    printf("Enter a non-negative integer: ");
    scanf("%u", &n);
    printf("Number of set bits: %d\n", countSetBits(n));
    return 0;
}
