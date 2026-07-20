#include <stdio.h>

#define SIZE 5

int stack[SIZE], top = -1;

// Push element into stack
void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
        return;
    }

    top++;
    stack[top] = value;
}

// Pop element from stack
void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }

    int popped = stack[top];
    top--;

    printf("Popped: %d\n", popped);
}

// Swap top two elements
void swapTop()
{
    if (top < 1)
    {
        printf("Not enough elements\n");
        return;
    }

    int temp = stack[top];
    stack[top] = stack[top - 1];
    stack[top - 1] = temp;
}

// Display stack from top to bottom
void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }

    printf("Remaining: ");

    for (int i = top; i >= 0; i--)
    {
        printf("%d ", stack[i]);
    }

    printf("\n");
}

int main()
{
    push(101);
    push(102);
    swapTop();

    pop();
    return 0;
}

    display();
    push(103);
