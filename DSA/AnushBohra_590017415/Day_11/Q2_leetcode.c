#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool isIsomorphic(char* s, char* t) {
    int map_s[256] = {0};
    int map_t[256] = {0};
    int len = strlen(s);
    
    for (int i = 0; i < len; i++) {
        unsigned char char_s = s[i];
        unsigned char char_t = t[i];
        
        if (map_s[char_s] != map_t[char_t]) {
            return false;
        }
        
        map_s[char_s] = i + 1;
        map_t[char_t] = i + 1;
    }
    
    return true;
}

void testIsomorphic(char* s, char* t) {
    printf("Input: s = \"%s\", t = \"%s\"\n", s, t);
    if (isIsomorphic(s, t)) {
        printf("Output: true\n\n");
    } else {
        printf("Output: false\n\n");
    }
}

int main() {
    testIsomorphic("egg", "add");
    testIsomorphic("f11", "b23");
    testIsomorphic("paper", "title");
    testIsomorphic("ab", "aa");

    return 0;
}