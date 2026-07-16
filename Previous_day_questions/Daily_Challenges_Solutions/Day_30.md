<h2 align="center">Week 5 Day 30 (14/07/2026)</h2>

## 1. Remove All Adjacent Duplicates In String (LeetCode #1047)

### Solution

```c
char* removeDuplicates(char* s) {
    int n = strlen(s);
    // Create a stack to store characters
    char *stack = (char *)malloc((n + 1) * sizeof(char));
    int top = -1;

    // Traverse the string
    for (int i = 0; i < n; i++) {
        // If current character matches the top of the stack,
        // remove the duplicate by popping
        if (top != -1 && stack[top] == s[i]) {
            top--;
        }
        else {
            // Otherwise push the current character
            stack[++top] = s[i];
        }
    }

    // Add null character to make it a valid string
    stack[top + 1] = '\0';

    // Return the final string
    return stack;
}
```

---

## 2. Insert Element at Bottom of Stack

### Solution

```c
#include <stdio.h>
#define MAX 100

int stack[MAX];
int top = -1;

// Push an element onto the stack
void push(int value) {
    if (top == MAX - 1) {
        printf("Stack Overflow\n");
        return;
    }
    stack[++top] = value;
}

// Pop the top element from the stack
int pop() {
    if (top == -1) {
        printf("Stack Underflow\n");
        return -1;
    }
    return stack[top--];
}

// Insert an element at the bottom of the stack
void insertAtBottom(int x) {
    // If stack is empty, insert the element
    if (top == -1) {
        push(x);
        return;
    }
    // Remove the top element
    int temp = pop();
    // Recursively insert x at the bottom
    insertAtBottom(x);
    // Push the removed element back
    push(temp);
}

// Display the stack from bottom to top
void display() {
    printf("Updated Stack: ");
    for (int i = 0; i <= top; i++) {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main() {
    int n, x;

    // Take number of elements
    printf("Enter number of elements in stack: ");
    scanf("%d", &n);

    printf("Enter stack elements (bottom to top): ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &stack[i]);
    }
    top = n - 1;

    // Take the element to insert
    printf("Enter element to insert at bottom: ");
    scanf("%d", &x);

    // Insert the element at the bottom
    insertAtBottom(x);

    // Print the updated stack
    display();

    return 0;
}
```
