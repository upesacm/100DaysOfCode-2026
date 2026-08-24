//Write an efficient function that encrypts a string by removing spaces, arranging characters into a grid with minimum area 
//where rows and columns are as close to √L as possible, and reading the grid column by column with spaces between columns.
//Input: "haveaniceday". Output: "hae and via ecy".
#include <stdio.h>
#include <string.h>
#include <math.h>

void encrypt(char *s) {
    char str[1000];
    int len = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ')
            str[len++] = s[i];
    }
    str[len] = '\0';
    int rows = (int)sqrt(len);
    int cols = rows;
    if (rows * cols < len)
        cols++;
    if (rows * cols < len)
        rows++;
    if (rows > cols) {
        int temp = rows;
        rows = cols;
        cols = temp;
    }
    for (int col = 0; col < cols; col++) {
        for (int row = 0; row < rows; row++) {
            int index = row * cols + col;

            if (index < len)
                printf("%c", str[index]);
        }
        if (col != cols - 1)
            printf(" ");
    }
    printf("\n");
}

int main() {
    char input[1000];
    printf("Enter a string: ");
    fgets(input, sizeof(input), stdin);
    encrypt(input);
return 0;
}