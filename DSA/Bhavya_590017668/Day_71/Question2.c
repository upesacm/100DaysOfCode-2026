#include <stdio.h>
#include <string.h>
#include <math.h>
void encryption(char *s) {
    int len = 0;
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ') {
            s[len++] = s[i];
        }
    }
    s[len] = '\0';
    int rows = (int)sqrt(len);
    int cols = (int)ceil(sqrt(len));
    if (rows * cols < len) {
        rows++;
    }
    for (int col = 0; col < cols; col++) {
        for (int row = 0; row < rows; row++) {
            int index = row * cols + col;

            if (index < len) {
                printf("%c", s[index]);
            }
        }

        if (col < cols - 1) {
            printf(" ");
        }
    }
}
int main() {
    char s[1000];
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';
    encryption(s);
    return 0;
}