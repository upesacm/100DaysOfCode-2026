bool isIsomorphic(char* s, char* t) {
    if (strlen(s) != strlen(t))
        return false;

    int map1[256];
    int map2[256];

    for (int i = 0; i < 256; i++) {
        map1[i] = -1;
        map2[i] = -1;
    }

    for (int i = 0; s[i] != '\0'; i++) {
        unsigned char c1 = s[i];
        unsigned char c2 = t[i];

        if (map1[c1] == -1 && map2[c2] == -1) {
            map1[c1] = c2;
            map2[c2] = c1;
        } else {
            if (map1[c1] != c2 || map2[c2] != c1)
                return false;
        }
    }

    return true;

}