#include<stdio.h>
int main()
{
    int numsSize;
    printf("Enter Array Size");
    scanf("%d",&numsSize);
    int arr[100];
    for(int i=0; i< numsSize; i++)
    {
        printf("Enter %d element",i+1);        
        scanf("%d",&arr[i]);
    }
    int val;
    int count=0;
    printf("Enter value to check its occurence");
    scanf("%d",&val);
    for(int i=0;i< numsSize; i++)
    {
        if(arr[i]== val)
        {
            count++;
        }
    }
    printf("Output %d\n",count);
    return 0;
}