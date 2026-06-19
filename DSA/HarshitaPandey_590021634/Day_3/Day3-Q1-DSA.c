/*  Q1: Given an sorted integer array and a target value, count the number of occurrences of the target 
in the array and return the result.
Example:
Input:[1,1,2,2,2,2]; target:2;  Output:4   */


#include <stdio.h>

int main()
{
    int n,i, target;
    int count=0;

    scanf("%d", &n);

    int arr[n];

    for(i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

    printf("Enter target value: ");
    scanf("%d", &target);


    for (i=0; i<n; i++)
    {
        if (arr[i] == target)
        {
            count++;
        }
    }

    printf("The occurrence of the target value: %d", count);
    
    return 0;
}