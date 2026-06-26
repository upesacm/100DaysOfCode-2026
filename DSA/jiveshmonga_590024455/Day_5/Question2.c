#include <stdio.h>
int checkEqual(int arr1[],int arr2[],int n)
{
    for(int i=0;i<n;i++)
    {
        if(arr1[i]!=arr2[i])
        {
            return 0;
        }
    }
    return 1;
}
int main()
{
    int n;
    printf("Enter size of arrays: ");
    scanf("%d",&n);
    int arr1[n],arr2[n];
    printf("Enter elements of first array: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr1[i]);
    }
    printf("Enter elements of second array: ");
    for(int i=0;i<n;i++)
    {
        scanf("%d",&arr2[i]);
    }
    if(checkEqual(arr1,arr2,n))
        printf("True");
    else
        printf("False");
    return 0;
}
