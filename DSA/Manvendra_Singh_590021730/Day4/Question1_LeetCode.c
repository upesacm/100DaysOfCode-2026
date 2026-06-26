// This function transposes a given 2D matrix. It takes the original matrix, its size, and column sizes as input, and returns the transposed matrix along with its size and column sizes.
int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes) {
    int m = matrixSize;
    int n = matrixColSize[0];

    // Allocate result matrix of size n x m
    int** result = (int**)malloc(n * sizeof(int*));
    *returnColumnSizes = (int*)malloc(n * sizeof(int));
    for (int i = 0; i < n; i++) {
        result[i] = (int*)malloc(m * sizeof(int));
        (*returnColumnSizes)[i] = m;
    }
    *returnSize = n;

    // Fill transposed values
    for (int i = 0; i < m; i++)
        for (int j = 0; j < n; j++)
            result[j][i] = matrix[i][j];

    return result;
}