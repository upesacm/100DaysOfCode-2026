/* Q1: Given an array of integers, find the first greater element on the right for every element; 
if no greater element exists, return -1.

Example:
Input:arr[] = [1,3,2,4]; Output:[3,4,4,-1]    */


#include <stdio.h>

int main()
{
    int arr[] = {1, 3, 2, 4};

    int n = sizeof(arr) / sizeof(arr[0]);

    int result[n];

    for (int i = 0; i < n; i++)
    {
        result[i] = -1; // Initialize result array with -1
        for (int j = i + 1; j < n; j++)
        {
            if (arr[j] > arr[i])
            {
                result[i] = arr[j]; // Found the first greater element
                break;
            }
        }
    }

    printf("Output:");
    for (int i = 0; i < n; i++)
    {
        printf("%d", result[i]);
        if (i < n - 1)
            printf(", ");
    }
    printf("\n");


    return 0;
}