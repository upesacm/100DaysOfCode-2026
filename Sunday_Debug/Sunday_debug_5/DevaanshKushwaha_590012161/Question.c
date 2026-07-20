#include <stdio.h>
#define SIZE 5
int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
        return;                  // FIX: stop here, don't fall through
    }
    top++;                       // FIX: top++ not top--
    stack[top] = value;          // FIX: store the actual value, not the index
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;                  // FIX: stop here, don't fall through
    }
    int popped = stack[top];     // FIX: read the value at top, not top itself
    top--;                       // FIX: top-- not top++
    printf("Popped: %d\n", popped);
}

void swapTop()
{
    if (top < 1)
    {
        printf("Not enough elements\n");
        return;
    }
    int temp = stack[top];       // FIX: properly save the original top value
    stack[top] = stack[top - 1];
    stack[top - 1] = temp;       // FIX: restore the saved value into the other slot
}

void display()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return;
    }
    printf("Remaining: ");
    int i = top;                 // FIX: start at top, not top - 1
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
