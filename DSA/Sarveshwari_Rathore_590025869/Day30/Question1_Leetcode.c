char *removeDuplicates(char *s){
    int len = strlen(s);
    char *stack = malloc(len + 1);
    int top = 0;
    int i=0;
    while (s[i] != '\0'){
        if(top == 0){
            stack[top++] = *s;
        }
        else if(s[i] != stack[top - 1]){
            stack[top++] = *s;
        }else{
            --top;
        }
        i++;
    }
    stack[top] = '\0';
    return stack;
}