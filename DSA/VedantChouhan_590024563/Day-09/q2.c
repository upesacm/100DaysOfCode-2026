#include <stdio.h>
#include <string.h>

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);

    int j = 0;

    for(int i = 0; s[i] != '\0'; i++) {
        if(s[i] != ' ' && s[i] != '\n') {
            s[j] = s[i];
            j++;
        }
    }

    s[j] = '\0';

    printf("String after removing spaces: %s\n", s);

    return 0;
}