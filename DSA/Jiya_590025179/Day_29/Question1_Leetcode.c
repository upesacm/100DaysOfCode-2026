bool isValid(char* s) {
    char stack[10000];
    int top=-1;
    for(int i=0;i<strlen(s);i++) {
        char a=s[i];
        if(a=='('||a=='['||a=='{') stack[++top]=a;
        else {
            if (top==-1) return 0;
            if  ((a==')' && stack[top]!='(')||(a==']' && stack[top]!='[')||(a=='}' && stack[top]!='{')) return false;
            top--;
        }
    }
    return top==-1;
}
