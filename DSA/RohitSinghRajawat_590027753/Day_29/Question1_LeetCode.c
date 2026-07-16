bool isValid(char* s) {
    
    int n = strlen(s);

    char *stack = (char *)malloc(n * sizeof(char));
    int top = -1;

    for (int i = 0; i < n; i++)
    {
        if (s[i] == '(' || s[i] == '[' || s[i] == '{')
        {
            stack[++top] = s[i];
        }
        else
        {
            if (top == -1)
            {
                free(stack);
                return false;
            }

            if ((s[i] == ')' && stack[top] != '(') ||
                (s[i] == ']' && stack[top] != '[') ||
                (s[i] == '}' && stack[top] != '{'))
            {
                free(stack);
                return false;
            }

            top--;
        }
    }

    bool valid = (top == -1);

    free(stack);

    return valid;
}