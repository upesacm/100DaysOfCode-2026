#include <stdio.h>
#include <string.h>

int compress(char chars[], int n) {

    int i = 0;
    int index = 0;

    while (i < n) {

        char current = chars[i];
        int count = 0;

        while (i < n && chars[i] == current) {
            count++;
            i++;
        }

        chars[index++] = current;

        if (count > 1) {

            char buffer[10];
            sprintf(buffer, "%d", count);

            for (int j = 0; buffer[j] != '\0'; j++) {
                chars[index++] = buffer[j];
            }
        }
    }

    return index;
}

int main() {

    char chars[] = {'a','a','b','b','c','c','c'};
    int n = sizeof(chars) / sizeof(chars[0]);

    int newLength = compress(chars, n);

    printf("Compressed Array: ");

    for (int i = 0; i < newLength; i++)
        printf("%c ", chars[i]);

    printf("\nNew Length = %d\n", newLength);

    return 0;
}