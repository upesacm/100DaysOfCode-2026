bool isIsomorphic(char* s, char* t) {
    int mapST[256] = {0};
    int mapTS[256] = {0};

    int i = 0;

    while (s[i] && t[i]) {
        unsigned char c1 = s[i];
        unsigned char c2 = t[i];

        if (mapST[c1] == 0 && mapTS[c2] == 0) {
            mapST[c1] = c2;
            mapTS[c2] = c1;
        }
        else if (mapST[c1] != c2 || mapTS[c2] != c1) {
            return false;
        }

        i++;
    }

    return s[i] == '\0' && t[i] == '\0';
}
