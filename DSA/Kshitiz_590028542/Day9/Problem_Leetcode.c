int lengthOfLastWord(char* s) {
    int count = 0;
    int i = strlen(s) - 1;
    
    if(s == NULL){
        return 0;
    }

    while (i >= 0 && s[i] == ' ') {
        i--;
    }
    
    while (i >= 0 && s[i] != ' ') {
        count++;
        i--;
    }

return count;
}