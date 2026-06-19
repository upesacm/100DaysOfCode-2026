/*   Q1: Given an integer array and an integer k, rotate the array to the right by k steps.
Example:
Input:nums = [1,2,3,4], k = 3. Output:[2,3,4,1]      */



#include <stdio.h>

void reverse(int* nums, int start, int end)
{
    while (start< end)
    {
        int temp= nums[start];
        nums[start]= nums[end];
        nums[end]= temp;
        start++;
        end--;
    }
}



void rotate(int* nums, int n, int k)
{
    k = k % n;

    reverse(nums, 0, n-1);
    reverse(nums, 0, k-1);
    reverse(nums, k, n-1);

}



int main()
{
    int n,i,k;

    scanf("%d", &n);

    int arr[n];

    printf("enter the elements: ");
    for (i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

    printf("enter k: ");
    scanf("%d", &k);


    printf("Array before rotation: ");
    for (i=0; i< n; i++)
    {
        printf("%d ", arr[i]);
    }

    rotate(arr, n, k);

    printf("Post rotation:");
    for (i=0; i< n; i++)
    {
        printf("%d ", arr[i]);
    }
    
    return 0;
}