#include <stdio.h>

int main()
{
    int rows, cols;

    scanf("%d %d", &rows, &cols);

    int a[100][100];
    int transpose[100][100];

    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < cols; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }

    for(int i = 0; i < rows; i++)
    {
        for(int j = 0; j < cols; j++)
        {
            transpose[j][i] = a[i][j];
        }
    }

    for(int i = 0; i < cols; i++)
    {
        for(int j = 0; j < rows; j++)
        {
            printf("%d ", transpose[i][j]);
        }
        printf("\n");
    }

    return 0;
}
