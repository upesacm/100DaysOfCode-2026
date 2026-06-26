int lengthOfLastWord(char* s) {
    int right = strlen(s) - 1;
    int count = 0;
    while(right >= 0 && s[right] == ' ') {
        right--;
    }
    while(right >= 0 && s[right] != ' ') {
        count++;
        right--;
    }
    return count;
}