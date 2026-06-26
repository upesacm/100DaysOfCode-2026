int strStr(char* haystack, char* needle) {

    int l1 = strlen(haystack);
    int l2 = strlen(needle);

    int i = 0;
    int j = 0;
    int idx = -1;

    for (i = 0; i <= l1 - l2; i++) {
        j = 0;
        while ( j< l2 && (haystack[i+j] == needle[j])) {
            j++;
        }
        if(j == l2) 
            return i;
        
    }
return -1;
}
