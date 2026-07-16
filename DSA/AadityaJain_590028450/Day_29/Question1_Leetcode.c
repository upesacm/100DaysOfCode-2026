/*Valid Parentheses
Explanation
Determine whether the given sequence of brackets is properly balanced using a stack. Return true if the string is valid; otherwise, return false.*/

bool isValid(char* s){

    int len = strlen(s);
    char stack[len];
    int top = -1;
    int i;
    
    for(i = 0; i < len; i++){
        if(s[i] == '(' || s[i] == '{' || s[i] == '['){
            stack[++top] = s[i];
        }
        else{
            if(top == -1){
                return false;
            }

            if((s[i] == ')' && stack[top] == '(') ||
               (s[i] == '}' && stack[top] == '{') ||
               (s[i] == ']' && stack[top] == '[')){
                top--; 
            }else{
                return false;
            }
        }
    }
    
    return (top == -1);
}