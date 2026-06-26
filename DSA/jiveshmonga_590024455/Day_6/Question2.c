#include <stdio.h>
void unionArray(int arr1[],int n1,int arr2[],int n2)
{
    int i=0,j=0;
    while(i<n1&&j<n2)
    {
        if(arr1[i]<arr2[j])
        {
            if(i==0||arr1[i]!=arr1[i-1])
                printf("%d ", arr1[i]);
            i++;
        }
        else if(arr2[j]<arr1[i])
        {
            if(j==0||arr2[j]!=arr2[j-1])
                printf("%d ",arr2[j]);
            j++;
        }
        else
        {
            if(i==0||arr1[i]!=arr1[i-1])
                printf("%d ",arr1[i]);
            i++;
            j++;
        }
    }
    while(i < n1)
    {
        if(i == 0 || arr1[i] != arr1[i-1])
            printf("%d ", arr1[i]);
        i++;
    }

    while(j<n2)
    {
        if(j==0||arr2[j]!=arr2[j-1])
            printf("%d ",arr2[j]);
        j++;
    }
}
int main()
{
    int arr1[]={1,2};
    int arr2[]={2,3};
    int n1=2,n2=2;
    printf("Union: ");
    unionArray(arr1,n1,arr2,n2);
    return 0;
}
