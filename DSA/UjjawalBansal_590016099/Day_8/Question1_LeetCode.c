bool isPalindrome(char* s) {
    int l = 0;
    int r = strlen(s) -1;
    while (l<r) {
        while (l<r && !isalnum((unsigned char)s[l])) l++;
        while (l<r && !isalnum((unsigned char)s[r])) r--;

        if (tolower((unsigned char)s[l++]) != tolower((unsigned char)s[r--])) return false;
    }
    return true;
}