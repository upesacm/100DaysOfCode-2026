#include <stdio.h>

#define MAX 100

int stack1[MAX], stack2[MAX], temp[MAX];
int top1 = -1, top2 = -1, top3 = -1;

// Push functions
void push1(int x)
{
    stack1[++top1] = x;
}

void push2(int x)
{
    stack2[++top2] = x;
}

void pushTemp(int x)
{
    temp[++top3] = x;
}

// Pop functions
int pop1()
{
    return stack1[top1--];
}

int popTemp()
{
    return temp[top3--];
}

// Display stack
void display(int stack[], int top)
{
    printf("[");

    for(int i = 0; i <= top; i++)
    {
        printf("%d", stack[i]);

        if(i != top)
            printf(",");
    }

    printf("]\n");
}

int main()
{
    // Original Stack
    push1(1);
    push1(2);
    push1(3);
    push1(4);

    // Step 1: Original -> Temp
    while(top1 != -1)
    {
        pushTemp(pop1());
    }

    // Step 2: Temp -> Original and Copy
    while(top3 != -1)
    {
        int x = popTemp();

        push1(x);
        push2(x);
    }

    printf("Copied Stack: ");
    display(stack2, top2);

    return 0;
}