/*  Q1: Given two arrays, determine whether they are equal. Two arrays are considered equal 
if they have the same size and corresponding elements are identical.

Example:
Input: arr1=[1,2,3,4]; arr2[4,3,2,1]. 
Output: True.  */


#include <stdio.h>
#include <stdbool.h>


void sort (int arr[], int n)
{
    for (int i=0; i< n-1; i++)
    {
        for (int j=0; j< n-i-1; j++)
        {
            if (arr[j] > arr[j+1])
            {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}





bool equalArrays (int arr1[], int arr2[], int n1, int n2)
{
    if (n1 != n2)
    {
        return false;
    }


    //sorting:

    sort(arr1, n1);
    sort(arr2, n2);


    for ( int i=0; i<n1; i++)
    {
        if (arr1[i] != arr2[i])
        {
            return false;
        }
    }
    return true;
}



int main()
{
    int n1,n2;

    scanf("%d", &n1);     //size of first array: arr1[]
    int arr1 [n1];

    for ( int i=0; i<n1; i++)
    {
        scanf("%d", &arr1[i]);
    }

    scanf("%d", &n2);    //size of second array: arr2[]
    int arr2 [n2];

    for ( int i=0; i<n2; i++)
    {
        scanf("%d", &arr2[i]);
    }


    int result= equalArrays(arr1, arr2, n1, n2);

    if (result)
    {
        printf("True\n");
    }

    else
    {
        printf("False\n");
    }
    return 0;
}