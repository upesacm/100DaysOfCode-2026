char* removeDuplicates(char* s) {
    int top=-1;
    for(int i=0;s[i]!='\0';i++){
        if(top!=-1 && s[top]==s[i]){
            top--;
        }
        else
        s[++top]=s[i];
    }
    s[top+1]='\0';
    return s;
}
