#include <stdio.h>
#include <string.h>

// Function to find the minimum string length after removing "AB" and "CD"
int minLength(char* s) {
    int n = strlen(s);
    char stack[n + 1];
    int top = -1;

    for (int i = 0; i < n; i++) {
        // If stack is not empty, check for "AB" or "CD" patterns
        if (top >= 0 && ((stack[top] == 'A' && s[i] == 'B') || 
                         (stack[top] == 'C' && s[i] == 'D'))) {
            top--; // Pop the character from the stack
        } else {
            stack[++top] = s[i]; // Push the current character
        }
    }

    // The size of the stack is the minimum possible length
    return top + 1;
}

int main() {
    // Test Case 1: Expected output = 2 (ABFCACDB -> FCAB -> FC)
    char str1[] = "ABFCACDB";
    printf("Input: %s\n", str1);
    printf("Minimum Length: %d\n\n", minLength(str1));

    // Test Case 2: Expected output = 5 (No AB or CD substrings)
    char str2[] = "ACBDE";
    printf("Input: %s\n", str2);
    printf("Minimum Length: %d\n", minLength(str2));

    return 0;
}