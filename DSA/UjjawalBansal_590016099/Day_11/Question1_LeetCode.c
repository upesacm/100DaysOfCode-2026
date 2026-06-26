bool isIsomorphic(char* s, char* t) {
    char arr1[95] = {0};
    char arr2[95] = {0};

    for (int i = 0; s[i] != '\0'; i++) {
        int id1 = s[i] - 32;
        int id2 = t[i] - 32;

        if (arr1[id1] == '\0' && arr2[id2] == '\0') {
            arr1[id1] = t[i];
            arr2[id2] = s[i];
        }
        else if (arr1[id1] != t[i] || arr2[id2] != s[i]) return false;
    }
    return true;
}