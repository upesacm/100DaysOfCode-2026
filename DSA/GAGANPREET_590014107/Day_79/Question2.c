#include <stdio.h>

int singleNumber(int nums[], int n) {
    int ans = 0;

    for (int i = 0; i < n; i++) {
        ans ^= nums[i];
    }

    return ans;
}

int main() {
    int n;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    int nums[n];

    printf("Enter elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    printf("Single number: %d\n", singleNumber(nums, n));

    return 0;
}
