#include <stdio.h>

#define MAX 100

int stack1[MAX], stack2[MAX], temp[MAX];
int top1 = -1, top2 = -1, top3 = -1;

// Push
void push(int stack[], int *top, int value)
{
    stack[++(*top)] = value;
}

// Pop
int pop(int stack[], int *top)
{
    return stack[(*top)--];
}

// Print stack from bottom to top
void printStack(int stack[], int top)
{
    printf("[");
    for (int i = 0; i <= top; i++)
    {
        printf("%d", stack[i]);
        if (i != top)
            printf(",");
    }
    printf("]");
}

int main()
{
    int n;
    scanf("%d", &n);

    // Input elements
    for (int i = 0; i < n; i++)
    {
        int x;
        scanf("%d", &x);
        push(stack1, &top1, x);
    }

    // Copy while preserving order
    while (top1 != -1)
    {
        push(temp, &top3, pop(stack1, &top1));
    }

    while (top3 != -1)
    {
        int x = pop(temp, &top3);
        push(stack1, &top1, x);   // Restore original stack
        push(stack2, &top2, x);   // Copy to second stack
    }

    printStack(stack2, top2);

    return 0;
}
