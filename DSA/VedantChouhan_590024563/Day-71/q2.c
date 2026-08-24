#include <stdio.h>
#include <string.h>
#include <math.h>

int main() {
    char str[1000];

    printf("Enter string: ");
    fgets(str, sizeof(str), stdin);

    char s[1000];
    int len = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        if (str[i] != ' ' && str[i] != '\n') {
            s[len++] = str[i];
        }
    }

    s[len] = '\0';

    int rows = (int)sqrt(len);
    int cols = rows;

    if (rows * cols < len)
        cols++;

    if (rows * cols < len)
        rows++;

    for (int col = 0; col < cols; col++) {

        if (col > 0)
            printf(" ");

        for (int row = 0; row < rows; row++) {
            int index = row * cols + col;

            if (index < len)
                printf("%c", s[index]);
        }
    }

    printf("\n");

    return 0;
}