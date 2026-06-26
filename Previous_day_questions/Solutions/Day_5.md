<h2 align="center">Week 1 Day 5 (19/06/2026)</h2>

## 1. Jump Game (LeetCode #55)

### Solution

```c
bool canJump(int* nums, int numsSize) {
    // Stores the farthest index we can reach
    int maxReach = 0;

    // Traverse the array
    for (int i = 0; i < numsSize; i++) {

        // If current index is not reachable
        if (i > maxReach) {
            return false;
        }

        // Update the farthest reachable index
        if (i + nums[i] > maxReach) {
            maxReach = i + nums[i];
        }

        // If we can reach the last index
        if (maxReach >= numsSize - 1) {
            return true;
        }
    }

    // Successfully traversed the array
    return true;
}
```

---

## 2. Check Equal Arrays

### Solution

```c
#include <stdio.h>
#include <stdbool.h>

// Function to sort an array using Bubble Sort
void bubbleSort(int arr[], int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap elements
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

// Function to check whether two arrays are equal
bool areEqual(int a[], int b[], int n) {
    // Sort both arrays
    bubbleSort(a, n);
    bubbleSort(b, n);
    // Compare corresponding elements
    for (int i = 0; i < n; i++) {
        if (a[i] != b[i]) {
            return false;
        }
    }
    return true;
}

int main() {
    int a[] = {1, 2, 5, 4, 0};
    int b[] = {2, 4, 5, 0, 1};
    int n = sizeof(a) / sizeof(a[0]);
    if (areEqual(a, b, n))
        printf("true");
    else
        printf("false");
    return 0;
}
```
