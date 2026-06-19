<h2 align="center">Week 1 Day 4 (18/06/2026)</h2>

## 1. Transpose Matrix (LeetCode #867)

### Solution

```c
// Function to transpose the matrix
int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes)
{
    // Number of rows in the transposed matrix
    *returnSize = *matrixColSize;
    // Allocate memory for column sizes of the transposed matrix
    *returnColumnSizes = (int*)malloc((*returnSize) * sizeof(int));
    // Every row in the transposed matrix has 'matrixSize' columns
    for (int i = 0; i < *returnSize; i++)
    {
        (*returnColumnSizes)[i] = matrixSize;
    }
    // Allocate memory for the transposed matrix
    int **result = (int**)malloc((*returnSize) * sizeof(int*));
    for (int i = 0; i < *returnSize; i++)
    {
        result[i] = (int*)malloc(matrixSize * sizeof(int));
    }
    // Copy elements in transposed positions
    for (int i = 0; i < matrixSize; i++)
    {
        for (int j = 0; j < *matrixColSize; j++)
        {
            result[j][i] = matrix[i][j];
        }
    }
    // Return the transposed matrix
    return result;
}
```

---

## 2. Rotate Array by K Steps

### Solution

```c
#include <stdio.h>

// Function to rotate the array to the right by k steps
void rotateArray(int arr[], int n, int k)
{
    // If k is greater than array size, reduce unnecessary rotations
    k = k % n;
    // Rotate the array one step at a time
    for (int i = 0; i < k; i++)
    {
        // Store the last element
        int last = arr[n - 1];
        // Shift all elements one position to the right
        for (int j = n - 1; j > 0; j--)
        {
            arr[j] = arr[j - 1];
        }
        // Place the last element at the beginning
        arr[0] = last;
    }
}

int main()
{
    int n, k;
    // Input array size
    printf("Enter the size of the array: ");
    scanf("%d", &n);
    int arr[n];
    // Input array elements
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    // Input number of rotations
    printf("Enter the value of k: ");
    scanf("%d", &k);
    // Rotate the array
    rotateArray(arr, n, k);
    // Display the rotated array
    printf("Array after rotation:\n");
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    return 0;
}
```
