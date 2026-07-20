#include <stdio.h>

#define SIZE 5

int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");      
    }

    top++;
    stack[top] = value;
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
    }

    int popped = stack[top];
    top--;

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

    int temp = a;
    a = b;
    b = temp;

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

    int i = top;

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