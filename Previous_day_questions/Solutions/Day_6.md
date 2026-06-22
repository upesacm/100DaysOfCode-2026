<h2 align="center">Week 1 Day 6 (20/06/2026)</h2>

## 1. House Robber II (LeetCode #213)

### Solution

```c
// Function to find the maximum money that can be robbed
// from a linear range of houses
int solve(int* arr, int left, int right) {
    int first = 0, second = 0;

    // Traverse the given range of houses
    for (int i = left; i <= right; i++) {

        // Choose the maximum of:
        // 1. Rob current house (second + arr[i])
        // 2. Skip current house (first)
        int ans = (second + arr[i] > first) ? second + arr[i] : first;

        // Update previous values
        second = first;
        first = ans;
    }

    return first;
}

int rob(int* nums, int numsSize) {

    // If there is only one house
    if (numsSize == 1)
        return nums[0];

    // Case 1: Exclude the last house
    int case1 = solve(nums, 0, numsSize - 2);

    // Case 2: Exclude the first house
    int case2 = solve(nums, 1, numsSize - 1);

    // Return the maximum amount from both cases
    return (case1 > case2) ? case1 : case2;
}
```

---

## 2. Union of Two Sorted Arrays

### Solution

```c
#include <stdio.h>

int main() {
    int a[100], b[100], c[200];
    int n, m;
    int i, j, k = 0, found;

    // Input size of first array
    scanf("%d", &n);
    // Input elements of first array
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);

    // Input size of second array
    scanf("%d", &m);
    // Input elements of second array
    for (i = 0; i < m; i++)
        scanf("%d", &b[i]);

    // Add unique elements from the first array to the union array
    for (i = 0; i < n; i++) {
        found = 0;
        // Check if the element already exists in the union array
        for (j = 0; j < k; j++) {
            if (a[i] == c[j]) {
                found = 1;
                break;
            }
        }
        // If not found, add it to the union array
        if (!found)
            c[k++] = a[i];
    }

    // Add unique elements from the second array to the union array
    for (i = 0; i < m; i++) {
        found = 0;
        // Check if the element already exists in the union array
        for (j = 0; j < k; j++) {
            if (b[i] == c[j]) {
                found = 1;
                break;
            }
        }
        // If not found, add it to the union array
        if (!found)
            c[k++] = b[i];
    }

    // Sort the union array in ascending order
    for (i = 0; i < k - 1; i++) {
        for (j = i + 1; j < k; j++) {
            if (c[i] > c[j]) {
                int temp = c[i];
                c[i] = c[j];
                c[j] = temp;
            }
        }
    }

    // Print the union array
    for (i = 0; i < k; i++)
        printf("%d ", c[i]);

    return 0;
}
```
