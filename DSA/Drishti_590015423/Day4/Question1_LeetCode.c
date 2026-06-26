/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes.
 * Note: Both returned array and *columnSizes array must be malloced,
 * assume caller calls free().
 */
#include <stdlib.h>

int** transpose(int** matrix, int matrixSize, int* matrixColSize,
                int* returnSize, int** returnColumnSizes) {

    int rows = matrixSize;
    int cols = matrixColSize[0];

    // Transposed matrix will have 'cols' rows
    *returnSize = cols;

    // Allocate column sizes array
    *returnColumnSizes = (int*)malloc(cols * sizeof(int));

    // Allocate result matrix
    int **result = (int**)malloc(cols * sizeof(int*));

    for (int i = 0; i < cols; i++) {
        (*returnColumnSizes)[i] = rows;
        result[i] = (int*)malloc(rows * sizeof(int));
    }

    // Fill transpose
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
        }
    }

    return result;
}
