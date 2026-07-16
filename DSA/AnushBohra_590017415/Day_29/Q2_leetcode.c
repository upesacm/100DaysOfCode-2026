#include <stdio.h>
#include <stdbool.h>
#include <string.h>

// Function to check if the input string has valid parentheses
bool isValid(char* s) {
    int len = strlen(s);
    
    // An odd length string can never be valid
    if (len % 2 != 0) {
        return false;
    }
    
    // Allocate stack memory
    char stack[len];
    int top = -1;
    
    for (int i = 0; s[i] != '\0'; i++) {
        char ch = s[i];
        
        // If it's an opening bracket, push it onto the stack
        if (ch == '(' || ch == '{' || ch == '[') {
            stack[++top] = ch;
        } 
        // If it's a closing bracket, check for matching opening bracket
        else {
            // Stack is empty but we have a closing bracket -> invalid
            if (top == -1) {
                return false;
            }
            
            char topChar = stack[top];
            if ((ch == ')' && topChar == '(') ||
                (ch == '}' && topChar == '{') ||
                (ch == ']' && topChar == '[')) {
                top--; // Match found, pop from stack
            } else {
                return false; // Mismatched brackets
            }
        }
    }
    
    // If the stack is empty, all brackets were matched correctly
    return top == -1;
}

int main() {
    // Array of test cases
    char* testCases[] = {
        "()",
        "()[]{}",
        "(]",
        "([)]",
        "{[]}",
        "["
    };
    
    int numTests = sizeof(testCases) / sizeof(testCases[0]);
    
    printf("--- Valid Parentheses Test Results ---\n");
    for (int i = 0; i < numTests; i++) {
        bool result = isValid(testCases[i]);
        printf("Input: \"%-8s\" -> Result: %s\n", 
               testCases[i], 
               result ? "VALID (True)" : "INVALID (False)");
    }
    
    return 0;
}