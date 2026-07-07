int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes) {
    
    int rows = matrixSize;
    int cols = matrixColSize[0];

    *returnSize = cols;

    *returnColumnSizes = (int*)malloc(cols * sizeof(int));
    for(int i = 0; i < cols; i++) {
        (*returnColumnSizes)[i] = rows;
    }

    int** result = (int**)malloc(cols * sizeof(int*));

    for(int i = 0; i < cols; i++) {
        result[i] = (int*)malloc(rows * sizeof(int));

        for(int j = 0; j < rows; j++) {
            result[i][j] = matrix[j][i];
        }
    }

    return result;
}