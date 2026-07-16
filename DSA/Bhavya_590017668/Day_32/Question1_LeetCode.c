int minLength(char* s) {
    int top = -1;
    for (int i = 0; s[i] != '\0'; i++) {
        if (top >= 0 && ((s[top] == 'A' && s[i] == 'B') || (s[top] == 'C' && s[i] == 'D'))) {
            top--;
        } else {
            s[++top] = s[i];
        }
    }
    return top + 1;
}