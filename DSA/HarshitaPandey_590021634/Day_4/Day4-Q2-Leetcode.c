/*  Q2: Given a 2D integer array matrix, return the transpose of matrix.
The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's
row and column indices.   */


#include <stdio.h>

int main()
{
    int m, n, i, j;
    int matrix[10][10], transpose[10][10];

    printf("enter rows (m) and columns(n): ");
    scanf("%d %d", &m, &n);


    printf("Enter matrix elements:\n");
    for (i = 0; i < m; i++) {
        for (j = 0; j < n; j++) {
            scanf("%d", &matrix[i][j]);
        }
    }

   
    for (i = 0; i < m; i++) 
    {
        for (j = 0; j < n; j++) 
        {
            transpose[j][i] = matrix[i][j];
        }
    }

    
    printf("Transpose of matrix:\n");
    for (i = 0; i < n; i++) 
    {
        for (j = 0; j < m; j++) 
        {
            printf("%d ", transpose[i][j]);
        }
        printf("\n");
    }

    return 0;
}

