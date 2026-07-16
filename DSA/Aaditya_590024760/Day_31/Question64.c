#include <stdio.h>

void nextGreaterElement(int* arr, int n) {
    int stack[n];
    int top = -1;
    int result[n];

    for (int i = 0; i < n; i++)
        result[i] = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && arr[stack[top]] < arr[i]) {
            int idx = stack[top--];
            result[idx] = arr[i];
        }
        stack[++top] = i;
    }

    printf("Element  →  Next Greater\n");
    printf("-------------------------\n");
    for (int i = 0; i < n; i++)
        printf("  %d\t →\t%d\n", arr[i], result[i]);
}

int main() {
    int n;

    printf("Enter size of array: ");
    scanf("%d", &n);

    int arr[n];
    printf("Enter elements: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    printf("\n");
    nextGreaterElement(arr, n);

    return 0;
}
