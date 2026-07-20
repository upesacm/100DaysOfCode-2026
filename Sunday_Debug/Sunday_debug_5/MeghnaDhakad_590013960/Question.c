#include <stdio.h>

#define SIZE 5

int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
        return; // Added return to prevent overflow
    }

    top++; // Increment top to move up the stack
    stack[top] = value; // Store the actual value, not the index
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return; // Added return to prevent underflow
    }

    int popped = stack[top]; // Grab the actual value from the stack
    top--; // Decrement top to shrink the stack

    printf("Popped: %d\n", popped);
}

void swapTop()
{
    if (top < 1)
    {
        printf("Not enough elements\n");
        return;
    }

    // Correct swap logic using a temporary variable
    int temp = stack[top];
    stack[top] = stack[top - 1];
    stack[top - 1] = temp;
}

void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }

    printf("Remaining: ");

    int i = top; // Start from top, not top - 1

    while (i >= 0)
    {
        printf("%d ", stack[i]);
        i--;
    }

    printf("\n");
}

int main()
{
    push(101);
    push(102);
    push(103);
    push(104);

    swapTop();

    pop();
    display();

    return 0;
}
