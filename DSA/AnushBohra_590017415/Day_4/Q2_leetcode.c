#include <stdio.h>
#include <stdlib.h>

int** transpose(int** matrix, int matrixSize, int* matrixColSize,
                int* returnSize, int** returnColumnSizes) {

    int rows = matrixSize;
    int cols = *matrixColSize;

    *returnSize = cols;

    *returnColumnSizes = (int*)malloc(cols * sizeof(int));

    for (int i = 0; i < cols; i++) {
        (*returnColumnSizes)[i] = rows;
    }

    int **result = (int**)malloc(cols * sizeof(int*));

    for (int i = 0; i < cols; i++) {
        result[i] = (int*)malloc(rows * sizeof(int));
    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
        }
    }

    return result;
}

int main() {

    int rows = 3;
    int cols = 3;

    int data[3][3] = {
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };

    int **matrix = (int**)malloc(rows * sizeof(int*));

    for(int i = 0; i < rows; i++) {
        matrix[i] = data[i];
    }

    int returnSize;
    int *returnColumnSizes;

    int **result = transpose(
        matrix,
        rows,
        &cols,
        &returnSize,
        &returnColumnSizes
    );

    printf("Transposed Matrix:\n");

    for(int i = 0; i < returnSize; i++) {
        for(int j = 0; j < returnColumnSizes[i]; j++) {
            printf("%d ", result[i][j]);
        }
        printf("\n");
    }

    for(int i = 0; i < returnSize; i++) {
        free(result[i]);
    }

    free(result);
    free(returnColumnSizes);
    free(matrix);

    return 0;
}