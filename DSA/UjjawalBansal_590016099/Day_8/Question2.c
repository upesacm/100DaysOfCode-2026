#include <stdio.h>
#include <string.h>

char* reverse(char* s) {
    if(!s || !*s) return NULL;

    int len = strlen(s);

    for (int i = 0; i<len/2; i++) {
        char temp = s[i];
        s[i] = s[len-1-i];
        s[len-1-i] = temp;
    }
    return s;
}

int main() {
    char s[1000];
    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\r\n")] = '\0';

    reverse(s);
    printf("Reversed String: %s", s);
}