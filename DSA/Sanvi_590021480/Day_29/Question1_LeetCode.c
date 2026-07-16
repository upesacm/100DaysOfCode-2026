bool isValid(char* s) {
    int i=0;
    char stack[10000];
    int top=-1;
    int n=strlen(s);
  do {
    char ch=s[i];

    if(ch=='(' || ch=='{' || ch=='[')
      stack[++top]=ch;
    else{
      if(top==-1){
        return 0;
      }
      char topch=stack[top--];

      if((ch==')' && topch!='(') || (ch=='}' && topch!='{') || (ch==']' && topch!='[')){
        return 0;
      }
    }
    i++;
  }while(i<n);

  return top==-1;
}
