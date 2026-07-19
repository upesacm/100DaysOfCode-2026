#include <stdio.h>

#define SIZE 100   // Chosen as the maximum stack capacity allowed by the constraints (1 <= SIZE <= 100), ensuring the stack can store up to 100 elements.
int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
        return;  // FIX: Added return because no more elements can be inserted after overflow.
    }

    top++; // FIX: Changed top-- to top++ because the stack grows upward when pushing.

    stack[top] = value; // FIX: Changed stack[top] = top to stack[top] = value .
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
        return; // FIX: Added return to prevent popping from an empty stack.
    }

    int popped = stack[top]; // FIX: Changed int popped = top to int popped = stack[top] because we need the element, not the top index.

    top--; // FIX: Changed top++ to top-- because removing an element moves the top pointer downward.

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
    int temp = a; // FIX: Changed temp = b to temp = a so the original top element is preserved.

    a = b; // FIX: Changed b = temp to a = b so 'a' receives the second element.
    b = temp;  // FIX: Changed a = stack[top - 1] to b = temp so 'b' receives the original top element.
    
    // Store the swapped elements back into their respective positions in the stack.
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

    int i = top ;  // FIX: Changed top - 1 to top because display should include the current top element.

    while (i >= 0)
    {
        printf("%d ", stack[i]);
        i--;
    }

    printf("\n");
}

int main()
{

    printf("push(101) push(102) push(103) push(104) swapTop() pop()\n");
    push(101);
    push(102);
    push(103);
    push(104);

    swapTop();

    pop();
    display();

    return 0;
}