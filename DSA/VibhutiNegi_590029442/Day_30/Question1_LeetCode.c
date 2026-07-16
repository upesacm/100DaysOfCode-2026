char* removeDuplicates(char* s) {
     int top = -1;
    int i = 0;
    while (s[i] != '\0') {
        if (top != -1 && s[top] == s[i]) {
            top--;         
        } else {
            top++;
            s[top] = s[i]; 
        }
        i++;
    }
    s[top + 1] = '\0'; 
    return s;
}