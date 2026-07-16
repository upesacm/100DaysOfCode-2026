#include <stdio.h>

void insertAtBottom(int* stack, int* top, int x) {
    if (*top == -1) {
        stack[++(*top)] = x;
        return;
    }

    int temp = stack[(*top)--];
    insertAtBottom(stack, top, x);
    stack[++(*top)] = temp;
}

int main() {
    int n, x;

    printf("Enter size of stack: ");
    scanf("%d", &n);

    int stack[n + 1];
    int top = -1;

    printf("Enter elements (bottom to top): ");
    for (int i = 0; i < n; i++)
        stack[++top] = i, scanf("%d", &stack[top]);

    printf("Enter element to insert at bottom: ");
    scanf("%d", &x);

    printf("\nOriginal stack (top to bottom): ");
    for (int i = top; i >= 0; i--)
        printf("%d ", stack[i]);

    insertAtBottom(stack, &top, x);

    printf("\nUpdated stack  (top to bottom): ");
    for (int i = top; i >= 0; i--)
        printf("%d ", stack[i]);
    printf("\n");

    return 0;
}
