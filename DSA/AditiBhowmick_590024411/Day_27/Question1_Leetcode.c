#include <stdio.h>
#include <string.h>

int compress(char chars[], int n) {
    int write = 0;
    int read = 0;

    while (read < n) {
        char current = chars[read];
        int count = 0;

        while (read < n && chars[read] == current) {
            read++;
            count++;
        }

        chars[write++] = current;

        if (count > 1) {
            char temp[10];
            sprintf(temp, "%d", count);

            for (int i = 0; temp[i] != '\0'; i++) {
                chars[write++] = temp[i];
            }
        }
    }

    return write;
}

int main() {
    int n;

    printf("Enter number of characters: ");
    scanf("%d", &n);

    char chars[2000];

    printf("Enter the characters:\n");
    for (int i = 0; i < n; i++) {
        scanf(" %c", &chars[i]);
    }

    int newLength = compress(chars, n);

    printf("Compressed array: ");
    for (int i = 0; i < newLength; i++) {
        printf("%c ", chars[i]);
    }

    printf("\nNew Length: %d\n", newLength);

    return 0;
}