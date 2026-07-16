#include <stdio.h>
#define MAX 100
int stack[MAX];
int top = -1;

void push(int x) {
    if (top < MAX - 1)
        stack[++top] = x;
    else
        printf("Stack Overflow!\n");
}

int pop() {
    if (top == -1) {
        printf("Stack Underflow!\n");
        return -1;
    }
    return stack[top--];
}

void insertBottom(int x) {
    if (top == -1) {
        push(x);
        return;
    }

    int temp = pop();
    insertBottom(x);
    push(temp);
}

int main() {
    int n, x;
    printf("Enter the number of elements in the stack: ");
    scanf("%d", &n);

    printf("Enter %d stack elements:\n", n);
    for (int i = 0; i < n; i++) {
        int val;
        scanf("%d", &val);
        push(val);
    }

    printf("Enter the element to insert at the bottom: ");
    scanf("%d", &x);

    insertBottom(x);

    printf("\nStack after inserting %d at the bottom:\n", x);
    for (int i = top; i >= 0; i--)
        printf("%d ", stack[i]);

    printf("\n");
    return 0;
}
