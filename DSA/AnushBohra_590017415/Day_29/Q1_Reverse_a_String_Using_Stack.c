#include <stdio.h>
#include <string.h>

// Function to reverse a string using a stack structure
void reverseString(char* s) {
    int len = strlen(s);
    
    // Allocate stack memory for the characters
    char stack[len];
    int top = -1;
    
    // Step 1: Push all characters of the string onto the stack
    for (int i = 0; i < len; i++) {
        stack[++top] = s[i];
    }
    
    // Step 2: Pop characters from the stack and print them
    // (Stacks are Last-In, First-Out, which naturally reverses the order)
    printf("Reversed String: ");
    while (top != -1) {
        printf("%c", stack[top--]);
    }
    printf("\n");
}

int main() {
    // Example test case
    char s[] = "hello";
    
    printf("Original String: %s\n", s);
    reverseString(s);
    
    // Additional test case
    char s2[] = "UPES_ACM";
    printf("\nOriginal String: %s\n", s2);
    reverseString(s2);
    
    return 0;
}