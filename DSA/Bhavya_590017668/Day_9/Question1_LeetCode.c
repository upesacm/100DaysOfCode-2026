int lengthOfLastWord(char* s) {
    int len = 0;
    int i = 0;
    while (s[i] != '\0') {
        i++;
    }
    i--;
    while (i >= 0 && s[i] == ' ') {
        i--;
    }
    while (i >= 0 && s[i] != ' ') {
        len++;
        i--;
    }
    return len;
}