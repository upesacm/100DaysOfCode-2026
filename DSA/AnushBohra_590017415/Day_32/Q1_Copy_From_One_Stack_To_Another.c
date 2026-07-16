#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define MAX 100

// Define the Stack structure
typedef struct {
    int data[MAX];
    int top;
} Stack;

// Initialize stack
void initStack(Stack* s) {
    s->top = -1;
}

// Check if stack is full
bool isFull(Stack* s) {
    return s->top == MAX - 1;
}

// Check if stack is empty
bool isEmpty(Stack* s) {
    return s->top == -1;
}

// Push element onto stack
void push(Stack* s, int value) {
    if (isFull(s)) {
        printf("Stack Overflow\n");
        return;
    }
    s->data[++(s->top)] = value;
}

// Pop element from stack
int pop(Stack* s) {
    if (isEmpty(s)) {
        printf("Stack Underflow\n");
        return -1;
    }
    return s->data[(s->top)--];
}

// Print the elements of a stack from bottom to top
void printStack(Stack s) {
    printf("[");
    for (int i = 0; i <= s.top; i++) {
        printf("%d", s.data[i]);
        if (i < s.top) {
            printf(", ");
        }
    }
    printf("]\n");
}

// Function to copy st1 to st2 preserving order
void copyStack(Stack* st1, Stack* st2) {
    Stack temp;
    initStack(&temp);

    // Step 1: Pop from st1 and push to temp (order reverses)
    while (!isEmpty(st1)) {
        push(&temp, pop(st1));
    }

    // Step 2: Pop from temp and push to st2 (and restore st1 if needed)
    while (!isEmpty(&temp)) {
        int element = pop(&temp);
        push(st2, element);
        push(st1, element); // Restores original stack
    }
}

int main() {
    Stack st1, st2;
    initStack(&st1);
    initStack(&st2);

    // Pushing example values: [1, 2, 3, 4]
    push(&st1, 1);
    push(&st1, 2);
    push(&st1, 3);
    push(&st1, 4);

    printf("Original st1: ");
    printStack(st1);

    // Perform the copy operation
    copyStack(&st1, &st2);

    printf("Output st2:   ");
    printStack(st2);

    return 0;
}