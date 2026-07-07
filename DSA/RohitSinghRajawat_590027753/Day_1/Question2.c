//Q2. Write an efficient function to calculate the sum of all elements in an integer array.
//(ACM DSA PROBLEM)
#include<Stdio.h>
    int arraysum(int arr[],int size)
   {
    int sum = 0;
    for(int i = 0;i<size;i++)
    {
        sum += arr[i];
    }
    return sum;
    }
int main()
{
    int arr[] = {4,5,6,9,10};
    int size = sizeof(arr) / sizeof(arr[0]);
    int result = arraysum(arr,size);
    printf("Sum = %d",result);

    return 0;
}
