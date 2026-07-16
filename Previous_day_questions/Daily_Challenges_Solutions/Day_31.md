<h2 align="center">Week 5 Day 31 (15/07/2026)</h2>

## 1. Final Prices With a Special Discount in a Shop (LeetCode #1475)

### Solution

```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    // Size of the output array
    *returnSize = pricesSize;
    // Create result array
    int *answer = (int *)malloc(pricesSize * sizeof(int));
    // Copy original prices into answer
    for (int i = 0; i < pricesSize; i++) {
        answer[i] = prices[i];
    }
    // Stack to store indices of prices
    int stack[pricesSize];
    int top = -1;
    // Traverse all prices
    for (int i = 0; i < pricesSize; i++) {
        // If current price is smaller or equal,
        // it becomes the discount for previous items
        while (top != -1 && prices[i] <= prices[stack[top]]) {
            int index = stack[top];
            top--;
            // Apply discount
            answer[index] = prices[index] - prices[i];
        }
        // Push current index into stack
        top++;
        stack[top] = i;
    }
    return answer;
}
```

---

## 2. Next Greater Element in Array

### Solution

```c
#include <stdio.h>

// Function to find the Next Greater Element for each array element
void nextGreaterElement(int arr[], int n) {
    int result[n];   // Stores the next greater element for each index
    int stack[n];    // Stack to store array elements
    int top = -1;

    // Traverse the array from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Remove all elements from the stack
        // that are smaller than or equal to the current element
        while (top != -1 && stack[top] <= arr[i]) {
            top--;
        }
        // If stack is empty, no greater element exists
        if (top == -1) {
            result[i] = -1;
        } else {
            // Top of the stack is the next greater element
            result[i] = stack[top];
        }
        // Push the current element onto the stack
        stack[++top] = arr[i];
    }

    // Print the result array
    printf("Next Greater Elements: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");
}

int main() {
    int arr[] = {1, 3, 2, 4};
    int n = sizeof(arr) / sizeof(arr[0]);
    nextGreaterElement(arr, n);
    return 0;
}
```
