#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* removeDuplicates(char* s) {
    int i = 0; 
    
    for (int j = 0; s[j] != '\0'; j++) {
        if (i > 0 && s[j] == s[i - 1]) {
            i--; // Pop from the stack
        } else {
            s[i] = s[j];
            i++;
        }
    }
    
    s[i] = '\0'; 
    return s;
}

int main() {
    char str1[] = "abbaca";
    printf("Original 1: abbaca\n");
    printf("Result 1:   %s\n\n", removeDuplicates(str1));

    char str2[] = "azxxzy";
    printf("Original 2: azxxzy\n");
    printf("Result 2:   %s\n", removeDuplicates(str2));

    return 0;
}