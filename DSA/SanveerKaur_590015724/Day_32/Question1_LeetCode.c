int minLength(char* s) {
    int top = -1;

    char stack[100001];

    for (int i = 0; s[i] != '\0'; i++) {
        char ch = s[i];

        if (top >= 0 &&
            ((stack[top] == 'A' && ch == 'B') ||
             (stack[top] == 'C' && ch == 'D'))) {
            
            top--;
        } 
        else {
            stack[++top] = ch;
        }
    }

    return top + 1;
}