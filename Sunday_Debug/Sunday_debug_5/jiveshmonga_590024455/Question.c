#include <stdio.h>

#define SIZE 5

int stack[SIZE], top = -1;

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

void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }

    printf("Remaining: ");

    for (int i = top; i >= 0; i--)
        printf("%d ", stack[i]);

    printf("\n");
}

int main()
{
    printf("push(101)\n");
    push(101);

    printf("push(102)\n");
    push(102);

    printf("push(103)\n");
    push(103);

    printf("push(104)\n");
    push(104);

    printf("swapTop()\n");
    swapTop();

    printf("pop()\n");
    pop();

    display();

    return 0;
}