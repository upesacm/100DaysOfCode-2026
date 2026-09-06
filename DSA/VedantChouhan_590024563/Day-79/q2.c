//q2.
#include <stdio.h>

int findSingle(int nums[], int n) {
    int result = 0;

    for (int i = 0; i < n; i++) {
        result = result ^ nums[i];
    }

    return result;
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

    int answer = findSingle(nums, n);

    printf("Element appearing once: %d\n", answer);

    return 0;
}