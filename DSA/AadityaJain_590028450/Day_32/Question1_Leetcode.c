/*Minimum String Length After Removing Substrings
Explanation
Remove all occurrences of "AB" and "CD" using a stack and return the minimum possible length of the remaining string.*/

int minLength(char* s) {
    int top = -1;
    int i;

    for(i = 0; s[i] != '\0'; i++){
        if(top >= 0 &&
            ((s[top] == 'A' && s[i] == 'B') ||
            (s[top] == 'C' && s[i] == 'D'))){
            top--;
        }else{
            s[++top] = s[i];
        }
    }

    top++;

    return top;
}