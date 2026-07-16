#define MAX 10000
char stack[MAX];
int top = -1;
void push(char ch){
    stack[++top] = ch;
}
char pop(){
    return stack[top--];
}

bool isValid(char* s) {
    int n = strlen(s);
    for(int i = 0; i < n; i++){
        if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
            push(s[i]);
        }
        else{
            if(top == -1)
                return false;
            if(s[i] == ')' && stack[top] == '(')
                pop();
            else if(s[i] == ']' && stack[top] == '[')
                pop();
            else if(s[i] == '}' && stack[top] == '{')
                pop();
            else
                return false;
        }
    }
    return top == -1;
}