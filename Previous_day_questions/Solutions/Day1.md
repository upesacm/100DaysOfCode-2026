<h2 align="center">Week 1 Day 1 (15/06/2026)</h2>

## 1. Missing Number

### Solution

```c
// Function to find the missing number
int missingNumber(int nums[], int numsSize) {
    // Sum of numbers from 0 to n
    int Total = numsSize * (numsSize + 1) / 2;
    
    // Calculate actual sum of array elements
    int actualSum = 0;
    for (int i = 0; i < numsSize; i++) {
        actualSum += nums[i];
    }

    // Missing number = Total - Actual Sum
    return Total - actualSum;
}
```

---

## 2. Find the Sum of Array Elements

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

    // Variable to store the sum of elements
    int sum=0;

    // Take array elements as input from the user
    printf("Enter %d elements:\n", n);
    for (int i=0;i<n;i++) {
        scanf("%d", &arr[i]);
    }

    // Traverse the array and calculate the sum
    for (int i=0;i<n;i++) {
        sum=sum+arr[i];
    }

    // Display the result
    printf("Sum of array elements is %d\n",sum);
    return 0;
}
```
