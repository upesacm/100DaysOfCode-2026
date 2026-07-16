<h2 align="center">Week 4 Day 27 (11/07/2026)</h2>

## 1. String Compression (LeetCode #443)

### Solution

```c
/**
 * Note: The returned array must be modified in-place.
 * Return the new length of the compressed array.
 */
int compress(char* chars, int charsSize) {
    // Pointer to write compressed characters
    int write = 0;
    // Pointer to read the original array
    int read = 0;

    while (read < charsSize) {
        // Current character
        char current = chars[read];
        int count = 0;

        // Count consecutive occurrences of the current character
        while (read < charsSize && chars[read] == current) {
            read++;
            count++;
        }

        // Write the character
        chars[write++] = current;

        // If frequency is greater than 1, write its digits
        if (count > 1) {
            // Store count digits in reverse order
            char temp[10];
            int index = 0;
            while (count > 0) {
                temp[index++] = (count % 10) + '0';
                count /= 10;
            }
            // Write digits in correct order
            for (int i = index - 1; i >= 0; i--) {
                chars[write++] = temp[i];
            }
        }
    }

    // Return the length of the compressed array
    return write;
}
```

---

## 2. Subarrays with Bounded Maximum

### Solution

```c
#include <stdio.h>

// Function to count subarrays whose maximum element
// is less than or equal to the given limit
int countSubarrays(int arr[], int n, int limit) {
    int count = 0;
    int length = 0;

    for (int i = 0; i < n; i++) {
        // If the current element is within the limit,
        // increase the current valid segment length
        if (arr[i] <= limit) {
            length++;
        } else {
            // Otherwise, start a new segment
            length = 0;
        }
        // Add the number of valid subarrays
        // ending at the current index
        count += length;
    }

    return count;
}

int main() {
    int n;

    // Input the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];

    // Input array elements
    printf("Enter the array elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    int left, right;

    // Input the range
    printf("Enter left and right: ");
    scanf("%d %d", &left, &right);

    // Count subarrays with maximum <= right
    int rightCount = countSubarrays(arr, n, right);
    // Count subarrays with maximum < left
    int leftCount = countSubarrays(arr, n, left - 1);

    // Required answer
    int result = rightCount - leftCount;
    printf("Number of valid subarrays = %d\n", result);

    return 0;
}
```
