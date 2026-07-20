#include <stdio.h>

#define SIZE 5

int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");    
        return; // Fix 1 -> Added return statement to prevent stack overflow  
    }

    top++;  // Fix 2 -> Incremented the top pointer instead of decrementing it (top-- originally)
    stack[top] = value; // Fix 3 -> Storing the actual ID in the stack, not the index
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return; // Fix 4 -> Added return statement to prevent stack underflow
    }

    int popped = stack[top]; // Fix 5 -> Storing the actual Task ID in the variable "popped" instead of the index
    top--; // Fix 6 -> Decremented the top pointer instead of incrementing it (top++ originally)

    printf("Popped: %d\n", popped);
}

void swapTop()
{
    if (top < 1)
    {
        printf("Not enough elements\n");
        return;
    }

    int a = stack[top];
    int b = stack[top - 1];

    // Fix 7 -> Correcting the swap logic
    int temp = b;
    b = a;
    a = temp;

    stack[top] = a;
    stack[top - 1] = b;
}

void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }

    printf("Remaining: ");

    int i = top; // Fix 8 -> Starting from "top" instead of "top - 1" so that the first element doesn't get skipped

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