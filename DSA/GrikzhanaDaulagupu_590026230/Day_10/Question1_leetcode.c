int strStr(char *haystack, char *needle) {
    int i, j;

    if (needle[0] == '\0')
        return 0;

    for (i = 0; haystack[i] != '\0'; i++) {
        j = 0;

        while (needle[j] != '\0' &&
               haystack[i + j] != '\0' &&
               haystack[i + j] == needle[j]) {
            j++;
        }

        if (needle[j] == '\0')
            return i;
    }

    return -1;
}
