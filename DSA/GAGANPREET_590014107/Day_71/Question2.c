#include <stdio.h>
#include <string.h>
#include <math.h>

void encryption(char *s) {
    char str[1000];
    int len = 0;

    // Remove spaces
    for (int i = 0; s[i] != '\0'; i++) {
        if (s[i] != ' ') {
            str[len++] = s[i];
        }
    }
    str[len] = '\0';

    // Find rows and columns
    int rows = floor(sqrt(len));
    int cols = ceil(sqrt(len));

    if (rows * cols < len) {
        rows++;
    }

    // Read column by column
    for (int col = 0; col < cols; col++) {
        if (col > 0)
            printf(" ");

        for (int row = 0; row < rows; row++) {
            int index = row * cols + col;

            if (index < len)
                printf("%c", str[index]);
        }
    }

    printf("\n");
}

int main() {
    char s[1000];

    fgets(s, sizeof(s), stdin);

    // Remove newline
    s[strcspn(s, "\n")] = '\0';

    encryption(s);

    return 0;
}
