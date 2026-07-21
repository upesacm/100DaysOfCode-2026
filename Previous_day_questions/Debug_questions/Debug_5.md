<h2 align="center">Week 5 Day 35 (19/07/2026) — Weekly Debug 5</h2>

## 1. Among Us - The Imposter Variable

The crewmates of Skeld Station are running a critical system diagnostic. Every completed task gets pushed onto a stack - a log that proves who did what and when. The stack is the only evidence that can expose the imposter and save the crew.

But something is deeply wrong inside the code itself. One variable is silently stealing another's value mid-operation. During a swap, a variable grabs the wrong value first - then hands it back to itself, leaving the real value untouched. Another variable pretends to store a task ID but secretly stores its own index instead. When the crew tries to pop the latest task, the variable meant to hold the result steals the stack pointer's value instead. And when the log is displayed, the top entry vanishes - skipped before anyone can read it.

The crewmates cannot identify the imposter. The emergency meeting is called. The stack is the only evidence - but the evidence itself has been tampered with.

You are the systems analyst. Fix the stack before the imposter wins the vote.

This problem is commonly asked in interviews and helps build concepts like:
- Stack (LIFO) operations
- Pointer / index manipulation
- Swapping logic
- Overflow and underflow handling

which are important for writing correct and reliable programs.

**Your task:** Identify and fix all bugs in the given code so that it produces the correct output.

### What the Code Must Do

- Push task IDs onto the stack correctly.
- Pop the most recent task first and print it (LIFO order).
- Swap the top two elements of the stack correctly.
- Display all remaining tasks from top to bottom after operations.
- Handle stack overflow and underflow gracefully.

### Constraints

- 1 <= SIZE <= 100
- Task IDs are positive integers.
- Stack must maintain LIFO order at all times.
- Correct the existing implementation - do not rewrite using another data structure.
- Multiple logical bugs exist.

### Examples

**Input:**
```
push(101)
push(102)
push(103)
push(104)
swapTop()
pop()
display()
```
**Output:**
```
Popped: 103
Remaining: 104 102 101
```

### Buggy Code

```c
#include <stdio.h>
#define SIZE 5
int stack[SIZE], top = -1;

void push(int value)
{
    if (top == SIZE - 1)
    {
        printf("Stack Full\n");
    }
    top--;
    stack[top] = top;
}

void pop()
{
    if (top == -1)
    {
        printf("Stack Empty\n");
    }
    int popped = top;
    top++;
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
    int temp = b;
    b = temp;
    a = stack[top - 1];
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
    int i = top - 1;
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
