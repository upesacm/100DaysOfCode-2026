#include <stdio.h>
#include <stdlib.h>

int* nextGreaterElement(int* arr, int n) {
    int* result = (int*)malloc(n * sizeof(int));
    int* stack = (int*)malloc(n * sizeof(int));
    int top = -1;

    for (int i = n - 1; i >= 0; i--) {
        while (top >= 0 && stack[top] <= arr[i]) {
            top--;
        }
        if (top == -1) {
            result[i] = -1;
        } else {
            result[i] = stack[top];
        }
        stack[++top] = arr[i];
    }

    free(stack);
    return result;
}

int main() {
    int arr[] = {1, 3, 2, 4};
    int n = sizeof(arr) / sizeof(arr[0]);

    int* result = nextGreaterElement(arr, n);

    for (int i = 0; i < n; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    free(result);
    return 0;
}