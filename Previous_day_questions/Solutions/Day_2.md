<h2 align="center">Week 1 Day 2 (16/06/2026)</h2>

## 1. Remove Element (LeetCode #27)

### Solution

```c
// Function to remove all occurrences of val from the array in-place
int removeElement(int* nums, int numsSize, int val) {
    // Index to track position of next valid element
    int k = 0;

    // Traverse the array
    for (int i = 0; i < numsSize; i++) {
        // If current element is not val, keep it
        if (nums[i] != val) {
            nums[k] = nums[i];
            k++;
        }
    }

    // Return count of remaining elements
    return k;
}
```

---

## 2. Find the Largest Element in an Array

### Solution

```c
#include <stdio.h>

int main() {
    // Variable to store the size of the array
    int n;

    // Take the size of the array as input
    printf("Enter the number of elements: ");
    scanf("%d", &n);

    // Declare the array
    int arr[n];

    // Take array elements as input from the user
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Assume the first element is the largest
    int max = arr[0];

    // Traverse the array and find the maximum element
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Display the result
    printf("Largest element in the array is %d\n", max);
    return 0;
}
```
