/* Q1: Given an integer array, determine the largest element present in the array.
Example:
Input:[3,7,9,2,5]. Output:9 */

#include <stdio.h>

int largest(int arr[], int n)
{
    int max=arr[0];

    for (int j=0; j<n ; j++)
    {
        if (arr[j] > max)
        {
            max= arr[j];
        }
    }

    return max;
}


int main()
{
    int n,i;

    scanf("%d",&n);

    int arr[n];

    for(i=0;i<n;i++)
    {
        scanf("%d",&arr[i]);
    }

    int result= largest(arr, n);
    printf("The largest number in the array: %d", result);

    return 0;
}