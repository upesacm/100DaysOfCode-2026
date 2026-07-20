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
    int temp = stack[top - 1]; 
    stack[top - 1] = stack[top];
    stack[top] = temp;
}
void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }
    printf("Remaining: ");
    int i = top;    // because top is already index started from 0
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
