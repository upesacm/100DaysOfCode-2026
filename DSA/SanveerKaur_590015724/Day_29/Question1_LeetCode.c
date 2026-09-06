#include <stdbool.h>
#include <string.h>

bool isValid(char* s) {
    int n = strlen(s);
    char stack[n];
    int top = -1;

    for (int i = 0; i < n; i++) {

        // Opening brackets → push into stack
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stack[++top] = s[i];
        }

        // Closing brackets
        else {
            // No opening bracket available
            if (top == -1) {
                return false;
            }

            char open = stack[top--];

            if ((s[i] == ')' && open != '(') ||
                (s[i] == '}' && open != '{') ||
                (s[i] == ']' && open != '[')) {
                return false;
            }
        }
    }

    // Stack must be empty
    return top == -1;
}