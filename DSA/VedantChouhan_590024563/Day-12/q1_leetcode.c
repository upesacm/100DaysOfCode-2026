#include <stdio.h>
#include <string.h>

int main() {

    int widths[26] = {
        10,10,10,10,10,10,10,10,10,10,
        10,10,10,10,10,10,10,10,10,10,
        10,10,10,10,10,10
    };

    char s[1000];

    printf("Enter the string: ");
    scanf("%s", s);

    int lines = 1;
    int currentWidth = 0;

    for(int i = 0; s[i] != '\0'; i++) {

        int width = widths[s[i] - 'a'];

        if(currentWidth + width <= 100) {
            currentWidth += width;
        }
        else {
            lines++;
            currentWidth = width;
        }
    }

    printf("[%d, %d]\n", lines, currentWidth);

    return 0;
}