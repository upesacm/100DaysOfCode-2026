#include <stdio.h>

void nextGreaterElement(int arr[], int n)
{
    int stack[n];
    int top = -1;
    int ans[n];

    for(int i = n - 1; i >= 0; i--)
    {
        while(top != -1 && stack[top] <= arr[i])
        {
            top--;
        }

        if(top == -1)
        {
            ans[i] = -1;
        }
        else
        {
            ans[i] = stack[top];
        }

        stack[++top] = arr[i];
    }

    printf("Next Greater Elements:\n");

    for(int i = 0; i < n; i++)
    {
        printf("%d ", ans[i]);
    }
}

int main()
{
    int arr[] = {1,3,2,4};
    int n = sizeof(arr)/sizeof(arr[0]);

    nextGreaterElement(arr,n);

    return 0;
}