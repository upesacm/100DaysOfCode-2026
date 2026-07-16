char* removeDuplicates(char* s) {
    int i=0,top=-1;
    for (int j=0;s[j]!='\0';j++){
        if (top>=0&&s[top]==s[j]){
            top--;
        }else{
            s[++top]=s[j];
        }
    }
    s[top+1]='\0';
    return s;
}
