#include <stdbool.h>
#include <string.h>
int nextValidChar(char* str, int index) {
    int skip = 0;
    while (index >= 0) {
        if (str[index] == '#') {
            skip++;
            index--;
        } else if (skip > 0) {
            skip--;
            index--;
        } else {
            break; 
        }
    }
    return index; 
}
bool backspaceCompare(char* s, char* t) {
    int i = strlen(s) - 1;
    int j = strlen(t) - 1;
    
    while (i >= 0 || j >= 0) {
        i = nextValidChar(s, i);
        j = nextValidChar(t, j);
        if (i < 0 && j < 0) {
            return true;
        }
        if (i < 0 || j < 0) {
            return false;
        }
        if (s[i] != t[j]) {
            return false;
        }
        i--;
        j--;
    }
    return true;
}