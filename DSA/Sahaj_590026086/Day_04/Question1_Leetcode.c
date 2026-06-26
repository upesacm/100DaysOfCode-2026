int** transpose(int** matrix,int matrixSize,int* matrixColSize,int* returnSize,int** returnColumnSizes){
    int rows=matrixSize;
    int cols=matrixColSize[0];
    int** result=(int**)malloc(cols*sizeof(int*));
    *returnColumnSizes=(int*)malloc(cols*sizeof(int));
    for(int i=0;i<cols;i++) {
        result[i]=(int*)malloc(rows*sizeof(int));
        (*returnColumnSizes)[i]=rows;
        for(int j=0;j<rows;j++){
            result[i][j]=matrix[j][i];
        }
    }
    *returnSize=cols;
    return result;
}
