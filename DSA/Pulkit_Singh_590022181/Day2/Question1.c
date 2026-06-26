#include <stdio.h>

int removeElement(int nums[], int n, int val) {
    int k = 0; 

    for (int i = 0; i < n; i++) {
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }

    return k; 
}

int main() {
    int n, val;

    scanf("%d", &n);

    int nums[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &nums[i]);
    }

    scanf("%d", &val);

    int k = removeElement(nums, n, val);

    printf("%d\n", k);

    return 0;
}