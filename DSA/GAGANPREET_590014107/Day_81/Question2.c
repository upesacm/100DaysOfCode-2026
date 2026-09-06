#include <stdio.h>

int singleNumber(int nums[], int n) {
    int ones = 0;
    int twos = 0;

    for (int i = 0; i < n; i++) {
        ones = (ones ^ nums[i]) & ~twos;
        twos = (twos ^ nums[i]) & ~ones;
    }

    return ones;
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter elements:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    int result = singleNumber(nums, n);

    printf("Element appearing once: %d\n", result);

    return 0;
}
