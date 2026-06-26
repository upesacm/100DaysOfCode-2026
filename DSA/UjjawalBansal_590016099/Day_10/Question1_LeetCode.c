int strStr(char* haystack, char* needle) {
    int i=0, j=0;
    while (haystack[i] != '\0' && strlen(haystack)-i-1 >= strlen(needle)-j-1) {
        if (haystack[i] == needle[j]) {
            i++;
            j++;
        }
        else {
            i -= (j-1);
            j=0;
        }
        if (needle[j] == '\0') return i - strlen(needle);
    }
    return -1;
}