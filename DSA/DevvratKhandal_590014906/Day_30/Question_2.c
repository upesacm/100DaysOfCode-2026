//Program to insert an element at the bottom of a stack using recursion
#include <stdio.h>

#define MAX 100

int stack[MAX];
int top = -1;

void push(int x) {
    stack[++top] = x;
}

int pop() {
    return stack[top--];
}

void insertBottom(int x) {
    if(top == -1) {
        push(x);
        return;
    }

    int temp = pop();
    insertBottom(x);
    push(temp);
}

void display() {
    for(int i = 0; i <= top; i++) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    int n, x;

    printf("Enter number of elements in stack: ");
    scanf("%d", &n);

    printf("Enter stack elements:\n");
    for(int i = 0; i < n; i++) {
        scanf("%d", &stack[++top]);
    }

    printf("Enter element to insert at bottom: ");
    scanf("%d", &x);

    insertBottom(x);

    printf("Stack after insertion:\n");
    display();

    return 0;
}
