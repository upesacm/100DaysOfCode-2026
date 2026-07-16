#include <stdio.h>

int countSubarrays(int arr[], int n, int bound)
{
    int count = 0;
    int result = 0;

    for (int i = 0; i < n; i++)
    {
        if (arr[i] <= bound)
        {
            count++;
        }
        else
        {
            count = 0;
        }

        result += count;
    }

    return result;
}

int countBoundedSubarrays(int arr[], int n, int l, int r)
{
    return countSubarrays(arr, n, r) -
           countSubarrays(arr, n, l - 1);
}

int main()
{
    int arr[] = {1, 2, 3, 4, 5};
    int n = sizeof(arr) / sizeof(arr[0]);

    int l = 2;
    int r = 5;

    printf("%d\n", countBoundedSubarrays(arr, n, l, r));

    return 0;
}