#include <stdio.h>

void reverse(int arr[], int left, int right)
{
    while (left < right)
    {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
}

void rotate(int arr[], int n, int k)
{
    k = k % n;     // Handle k > n

    reverse(arr, 0, n - 1);      // Reverse whole array
    reverse(arr, 0, k - 1);      // Reverse first k elements
    reverse(arr, k, n - 1);      // Reverse remaining elements
}

int main()
{
    int n, k;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements: ");
    for(int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }

    printf("Enter k: ");
    scanf("%d", &k);

    rotate(arr, n, k);

    printf("Rotated Array: ");
    for(int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }

    return 0;
}