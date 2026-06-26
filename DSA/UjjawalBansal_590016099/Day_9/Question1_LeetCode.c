int lengthOfLastWord(char* s) {
    int l = strlen(s)-1;
    while(s[l] == ' ') l--;
    
    int a = 0;
    while(l>=0 && s[l] != ' ') {l--; a++;}
    return a;
}