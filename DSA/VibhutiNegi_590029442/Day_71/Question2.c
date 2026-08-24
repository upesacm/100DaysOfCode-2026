#include <stdio.h>
#include <string.h>
#include <math.h>
int main() {
    char s[100005];
    scanf(" %[^\n]", s);
    char str[100005];
    int len = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ') {
            str[len++] = s[i];
        }
    }
    str[len] = '\0';
    int rows = (int)sqrt(len);
    int cols;
    if (rows * rows < len)
        rows++;
    cols = (len + rows - 1) / rows;
    for (int j = 0; j < cols; j++) {
        if (j > 0)
            printf(" ");

        for (int i = 0; i < rows; i++) {
            int index = i * cols + j;

            if (index < len)
                printf("%c", str[index]);
        }
    }

    printf("\n");

    return 0;
}