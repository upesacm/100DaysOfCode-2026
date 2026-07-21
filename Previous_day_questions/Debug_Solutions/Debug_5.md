<h2 align="center">Week 5 Day 35 (19/07/2026) — Weekly Debug 5</h2>

## 1. Among Us - The Imposter Variable

### Solution

```c
#include <stdio.h>
#define SIZE 5
int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
        // BUG: missing return let push keep running even when the stack was full
        return;
    }
    // BUG: pointer was decremented instead of incremented
    top++;
    // BUG: variable secretly stored its own index instead of the given value
    stack[top] = value;
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        // BUG: missing return let pop keep running even when the stack was empty
        return;
    }
    // BUG: the result variable stole the stack pointer's value instead of the top element
    int popped = stack[top];
    // BUG: pointer was incremented instead of decremented
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
    // BUG: temp grabbed the wrong value first, so the real value of "a" was never preserved
    int temp = a;
    // BUG: a variable handed itself its own value back instead of the other's
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
    // BUG: starting index skipped the top entry before it could be read
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
```
