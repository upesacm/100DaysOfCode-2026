#include <stdio.h>

#define MAX 100

int stack[MAX];
int top = -1;

// Push operation
void push(int x) {
    if (top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = x;
}

// Pop operation
int pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}

// Insert element at the bottom
void insertAtBottom(int x) {

    if (top == -1) {
        push(x);
        return;
    }

    int temp = pop();

    insertAtBottom(x);

    push(temp);
}

// Print stack from bottom to top
void printStack() {
    printf("Stack: [");

    for (int i = 0; i <= top; i++) {
        printf("%d", stack[i]);
        if (i != top)
            printf(",");
    }

    printf("]\n");
}

int main() {

    push(1);
    push(2);
    push(3);
    push(4);

    int x = 5;

    printf("Original ");
    printStack();

    insertAtBottom(x);

    printf("Updated ");
    printStack();

    return 0;
}