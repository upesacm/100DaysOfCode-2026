#include <stdio.h>

#define MAX 100

typedef struct
{
    int items[MAX];
    int top;
} Stack;

void initialize(Stack *stack)
{
    stack->top = -1;
}

int isEmpty(Stack *stack)
{
    return stack->top == -1;
}

int isFull(Stack *stack)
{
    return stack->top == MAX - 1;
}

void push(Stack *stack, int value)
{
    if (!isFull(stack))
    {
        stack->items[++stack->top] = value;
    }
}

int pop(Stack *stack)
{
    if (!isEmpty(stack))
    {
        return stack->items[stack->top--];
    }

    return -1;
}

void insertAtBottom(Stack *stack, int value)
{
    if (isEmpty(stack))
    {
        push(stack, value);
        return;
    }

    int topElement = pop(stack);

    insertAtBottom(stack, value);

    push(stack, topElement);
}

void printStack(Stack *stack)
{
    for (int i = 0; i <= stack->top; i++)
    {
        printf("%d ", stack->items[i]);
    }

    printf("\n");
}

int main()
{
    Stack stack;
    initialize(&stack);

    push(&stack, 1);
    push(&stack, 2);
    push(&stack, 3);
    push(&stack, 4);

    int x = 5;

    insertAtBottom(&stack, x);

    printStack(&stack);

    return 0;
}