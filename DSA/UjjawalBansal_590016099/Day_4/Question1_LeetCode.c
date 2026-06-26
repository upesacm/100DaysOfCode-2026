int** transpose(int** matrix, int matrixSize, int* matrixColSize, int* returnSize, int** returnColumnSizes) {
    int r = matrixSize;
    int c = matrixColSize[0];
    *returnSize = c;
    *returnColumnSizes = malloc(c*sizeof(int));

    for(int i=0; i<c; i++) {
        (*returnColumnSizes)[i] =r;
    }

    int** ans = malloc(c*sizeof(int*));
    for(int i=0; i<c; i++) {
        ans[i] = malloc(r* sizeof(int));
    }

    for(int i = 0; i < c; i++) {
        for(int j = 0; j < r; j++) {
            ans[i][j] = matrix[j][i];
        }
    }
    return ans;
}