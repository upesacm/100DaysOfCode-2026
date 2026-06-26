int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes) {
    int rows = matrixSize;
    int cols = matrixColSize[0];
    *returnSize = cols;
    *returnColumnSizes = (int*)malloc(cols * sizeof(int));
    int** result = (int**)malloc(cols * sizeof(int*));
    for(int i = 0; i < cols; i++) {
        result[i] = (int*)malloc(rows * sizeof(int));
        (*returnColumnSizes)[i] = rows;
    }
    for(int i = 0; i < rows; i++) {
        for(int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
        }
    }
    return result;
}