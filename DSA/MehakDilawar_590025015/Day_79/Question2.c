//Given an integer array where every element appears exactly twice except one element that appears once, 
//find the element that appears only once using bit manipulation.
//Input: nums = [4, 1, 2, 1, 2, 4, 7]. Output: 7.
#include <stdio.h>

int main() {
    int n, num, result = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);

    for (int i = 0; i < n; i++) {
        scanf("%d", &num);
        result ^= num;
    }

    printf("Element that appears only once: %d\n", result);

    return 0;
}
