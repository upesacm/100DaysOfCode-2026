<h2 align="center">Week 5 Day 29 (13/07/2026)</h2>

## 1. Valid Parentheses (LeetCode #20)

### Solution

```c
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
bool isValid(char* s) {
    int n = strlen(s);
    // Create a stack to store opening brackets
    char *stack = (char *)malloc((n + 1) * sizeof(char));
    int top = -1;

    // Traverse the string
    for (int i = 0; i < n; i++) {
        // If current character is an opening bracket, push it
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stack[++top] = s[i];
        }
        else {
            // If stack is empty, closing bracket has no match
            if (top == -1) {
                free(stack);
                return false;
            }
            // Check if the top of stack matches current closing bracket
            if ((s[i] == ')' && stack[top] == '(') ||
                (s[i] == '}' && stack[top] == '{') ||
                (s[i] == ']' && stack[top] == '[')) {
                // Matching pair found, pop the opening bracket
                top--;
            }
            else {
                // Brackets do not match
                free(stack);
                return false;
            }
        }
    }

    // String is valid only if stack becomes empty
    bool ans = (top == -1);
    free(stack);
    return ans;
}
```

---

## 2. Reverse a String Using Stack

### Solution

```c
#include <stdio.h>
#include <string.h>

int main() {
    char str[100];

    // Take input string
    printf("Enter a string: ");
    scanf("%s", str);

    int n = strlen(str);

    // Stack to store characters
    char stack[100];
    int top = -1;

    // Push all characters of the string onto the stack
    for (int i = 0; i < n; i++) {
        stack[++top] = str[i];
    }

    // Pop characters from the stack to get the reversed string
    printf("Reversed string: ");
    while (top != -1) {
        printf("%c", stack[top--]);
    }
    printf("\n");

    return 0;
}
```
