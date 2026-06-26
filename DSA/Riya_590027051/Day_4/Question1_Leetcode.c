/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced.
 */
int** transpose(int** matrix, int matrixSize, int* matrixColSize, 
                int* returnSize, int** returnColumnSizes) {
    
    int m = matrixSize;           // number of rows
    int n = matrixColSize[0];     // number of columns
    
    // Transposed matrix will have n rows and m columns
    *returnSize = n;
    
    // Allocate memory for returnColumnSizes
    *returnColumnSizes = (int*)malloc(n * sizeof(int));
    
    // Allocate memory for transpose matrix
    int** result = (int**)malloc(n * sizeof(int*));
    
    for (int i = 0; i < n; i++) {
        (*returnColumnSizes)[i] = m;
        result[i] = (int*)malloc(m * sizeof(int));
    }
    
    // Fill transpose
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            result[j][i] = matrix[i][j];
        }
    }
    
    return result;
}
