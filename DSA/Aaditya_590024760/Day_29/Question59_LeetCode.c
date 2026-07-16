bool isValid(char* s) {
    int n = strlen(s);
    char stack[n + 1];
    int top = -1;

    for (int i = 0; i < n; i++) {
        if (s[i] == '(' || s[i] == '{' || s[i] == '[') {
            stack[++top] = s[i];
        } else {
            if (top == -1)
                return false;

            char t = stack[top--];

            if (s[i] == ')' && t != '(') return false;
            if (s[i] == '}' && t != '{') return false;
            if (s[i] == ']' && t != '[') return false;
        }
    }

    return top == -1;
}
