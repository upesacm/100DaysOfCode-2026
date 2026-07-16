char* removeDuplicates(char* s) {
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {
        if (top >= 0 && s[top] == s[i]) {
            top--;          // Remove duplicate
        } else {
            s[++top] = s[i]; // Push character
        }
    }

    s[top + 1] = '\0';
    return s;
}