#include <stdlib.h>

int* nextGreaterElement(int arr[], int n)
{
    int *result = (int *)malloc(n * sizeof(int));

    int stack[n];
    int top = -1;

    for (int i = n - 1; i >= 0; i--)
    {
        while (top >= 0 && stack[top] <= arr[i])
        {
            top--;
        }

        if (top == -1)
            result[i] = -1;
        else
            result[i] = stack[top];

        stack[++top] = arr[i];
    }

    return result;
}