// Problem 1 
// Minimum String Length After Removing Substrings 
// LeetCode Problem 2696

int minLength(char* s) {
    int n = strlen(s);
    char stack[n];
    int top = -1;

    for (int i = 0; i < n; i++) {
        if (top != -1 && ((stack[top] == 'A' && s[i] == 'B') || (stack[top] == 'C' && s[i] == 'D'))) {
            top--;      
        }
        else {
            stack[++top] = s[i];    
        }
    }
    return top + 1;
}