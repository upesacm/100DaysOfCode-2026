#include <stdio.h>
#include <stdlib.h>

#define MAX 100

// Stack structure definition
struct Stack {
    int arr[MAX];
    int top;
};

// Function to initialize the stack
void initStack(struct Stack* s) {
    s->top = -1;
}

// Check if the stack is empty
int isEmpty(struct Stack* s) {
    return s->top == -1;
}

// Push an element onto the stack
void push(struct Stack* s, int val) {
    if (s->top >= MAX - 1) {
        return;
    }
    s->arr[++(s->top)] = val;
}

// Pop an element from the stack
int pop(struct Stack* s) {
    if (isEmpty(s)) {
        return -1;
    }
    return s->arr[(s->top)--];
}

// Recursive function to insert an element at the bottom
void insertAtBottom(struct Stack* s, int x) {
    // Base case: if stack is empty, push x
    if (isEmpty(s)) {
        push(s, x);
        return;
    }

    int temp = pop(s);

    insertAtBottom(s, x);

    push(s, temp);
}

// Function to print the stack from bottom to top
void printStack(struct Stack* s) {
    printf("[");
    for (int i = 0; i <= s->top; i++) {
        printf("%d", s->arr[i]);
        if (i < s->top) {
            printf(",");
        }
    }
    printf("]\n");
}

int main() {
    struct Stack s;
    initStack(&s);

    push(&s, 1);
    push(&s, 2);
    push(&s, 3);
    push(&s, 4);

    int x = 5;

    printf("Original Stack (Bottom to Top): ");
    printStack(&s);

    insertAtBottom(&s, x);

    printf("Updated Stack (Bottom to Top):  ");
    printStack(&s);

    return 0;
}