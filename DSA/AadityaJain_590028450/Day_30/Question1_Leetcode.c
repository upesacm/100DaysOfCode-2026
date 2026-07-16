/*Remove All Adjacent Duplicates In String
Explanation
Repeatedly remove adjacent duplicate characters from a string using a stack until no duplicate pairs remain.*/


char* removeDuplicates(char* s) {
    int top = -1;
    int i;
    for(i = 0; s[i] != '\0'; i++){
        if(top >= 0 && s[top] == s[i]){
            top--;          
        }else{
            s[++top] = s[i]; 
        }
    }

    top++;
    s[top] = '\0'; 
    return s;
}