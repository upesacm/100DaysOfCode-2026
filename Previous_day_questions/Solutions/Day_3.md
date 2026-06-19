<h2 align="center">Week 1 Day 3 (17/06/2026)</h2>

## 1. Plus One (LeetCode #66)

### Solution

```c
// Function to add one to the number represented by the array
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    // Traverse the array from the last digit
    for (int i = digitsSize - 1; i >= 0; i--) {
        // If current digit is less than 9, increment and return
        if (digits[i] < 9) {
            digits[i]++;
            *returnSize = digitsSize;
            return digits;
        }
        // Otherwise set digit to 0 and carry over to the next digit
        digits[i] = 0;
    }

    // If all digits were 9, allocate a new array with an extra leading digit
    int* result = (int*)malloc((digitsSize + 1) * sizeof(int));
    result[0] = 1;
    for (int i = 0; i < digitsSize; i++) {
        result[i + 1] = 0;
    }

    *returnSize = digitsSize + 1;
    return result;
}
```

---

## 2. Number of Occurrences

### Solution

```c
#include <stdio.h>

// Function to count the occurrences of the target element
int countOccurrences(int arr[], int n, int target)
{
    int count = 0;
    // Traverse the entire array
    for (int i = 0; i < n; i++)
    {
        // If the current element matches the target,
        // increase the count
        if (arr[i] == target)
        {
            count++;
        }
    }
    // Return the total count
    return count;
}

int main()
{
    int n, target;
    // Read the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int arr[n];
    // Read the array elements
    printf("Enter %d sorted elements:\n", n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    // Read the target element
    printf("Enter the target element: ");
    scanf("%d", &target);
    // Call the function to count occurrences
    int result = countOccurrences(arr, n, target);
    // Display the result
    printf("Number of occurrences of %d = %d\n", target, result);
    return 0;
}
```
