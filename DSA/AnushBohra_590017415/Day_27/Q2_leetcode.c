#include <stdio.h>

int compress(char* chars, int charsSize) {
    int write = 0;
    int read = 0;

    while (read < charsSize) {
        char currentChar = chars[read];
        int count = 0;

        while (read < charsSize && chars[read] == currentChar) {
            read++;
            count++;
        }

        chars[write++] = currentChar;

        if (count > 1) {
            char countStr[10];
            int len = sprintf(countStr, "%d", count);
            for (int i = 0; i < len; i++) {
                chars[write++] = countStr[i];
            }
        }
    }

    return write;
}

int main() {
    char chars1[] = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    int size1 = sizeof(chars1) / sizeof(chars1[0]);
    int newLen1 = compress(chars1, size1);
    
    printf("%d\n", newLen1);
    for (int i = 0; i < newLen1; i++) {
        printf("%c ", chars1[i]);
    }
    printf("\n\n");

    char chars2[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    int size2 = sizeof(chars2) / sizeof(chars2[0]);
    int newLen2 = compress(chars2, size2);
    
    printf("%d\n", newLen2);
    for (int i = 0; i < newLen2; i++) {
        printf("%c ", chars2[i]);
    }
    printf("\n");

    return 0;
}