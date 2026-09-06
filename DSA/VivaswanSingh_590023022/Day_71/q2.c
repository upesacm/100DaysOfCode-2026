#include <stdio.h>
#include <string.h>
#include <math.h>

void encryption(char *s)
{
    char str[10000];
    int len = 0;

    // Remove spaces
    for (int i = 0; s[i] != '\0'; i++)
    {
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

    for (int col = 0; col < cols; col++)
    {
        int printed = 0;

        for (int row = 0; row < rows; row++)
        {
            int index = row * cols + col;

            if (index < len)
            {
                if (printed)
                    printf("%c", str[index]);

                else
                {
                    printf("%c", str[index]);
                    printed = 1;
                }
            }
        }

        if (col != cols - 1)
            printf(" ");
    }

    printf("\n");
}

int main()
{
    char s[10000];

    fgets(s, sizeof(s), stdin);

    encryption(s);

    return 0;
}