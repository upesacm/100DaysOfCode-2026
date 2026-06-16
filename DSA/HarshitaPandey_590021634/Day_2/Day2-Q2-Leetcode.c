/* Given an integer array nums and an integer val, remove all occurrences of val in-place and 
return the number of remaining elements.   */


#include <stdio.h>

int main()
{
    int n,i,val;
    int k=0;

    printf("enter n: ");
    scanf("%d", &n);

    int arr[n];

    for (int i=0; i<n ; i++)
    {
        scanf("%d", &arr[i]);
    }


    printf("enter the value: ");
    scanf("%d", &val);

    for (i=0; i< n; i++)
    {
        if (arr[i] != val)
        {
            arr[k] = arr[i];
            k++;
        }
    }

    printf("The number of values remaining in the array that are not equal to val: %d", k);

    return 0;
}




