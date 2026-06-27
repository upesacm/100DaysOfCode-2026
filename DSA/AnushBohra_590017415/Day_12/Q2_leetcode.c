#include <stdio.h>
#include <stdlib.h>

int* numberOfLines(int* widths, int widthsSize, char* s, int* returnSize)
{
    int *result = (int *)malloc(2 * sizeof(int));

    int lines = 1;
    int currentWidth = 0;

    for (int i = 0; s[i] != '\0'; i++)
    {
        int w = widths[s[i] - 'a'];

        if (currentWidth + w <= 100)
        {
            currentWidth += w;
        }
        else
        {
            lines++;
            currentWidth = w;
        }
    }

    result[0] = lines;
    result[1] = currentWidth;

    *returnSize = 2;

    return result;
}

int main()
{
    int widths[26];

    for (int i = 0; i < 26; i++)
        widths[i] = 10;

    char s[] = "abcdefghijklmnopqrstuvwxyz";

    int returnSize;
    int *ans = numberOfLines(widths, 26, s, &returnSize);

    printf("Lines = %d\n", ans[0]);
    printf("Last Line Width = %d\n", ans[1]);

    free(ans);

    return 0;
}