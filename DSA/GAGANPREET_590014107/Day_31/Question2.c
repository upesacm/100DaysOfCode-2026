#include <stdio.h>
#include <stdlib.h>

int* nextGreaterElement(int arr[], int n) {
    int *result = (int *)malloc(n * sizeof(int));

    int stack[n];
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        while (top != -1 && stack[top] <= arr[i])
            top--;

        if (top == -1)
            result[i] = -1;
        else
            result[i] = stack[top];

        stack[++top] = arr[i];
    }

    return result;
}

int main() {
    int n;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];

    printf("Enter array elements:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    int *result = nextGreaterElement(arr, n);

    printf("Next Greater Elements: ");
    for (int i = 0; i < n; i++)
        printf("%d ", result[i]);

    printf("\n");

    free(result);

    return 0;
}
