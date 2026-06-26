class Solution {
    public int[][] transpose(int[][] matrix) {
    int x=matrix.length;
    int y=matrix[0].length;
    int mat[][]=new int[y][x];

     for(int i =0;i<x;i++){
        for(int j=0;j<y;j++){
            mat[j][i] = matrix[i][j];
        }
     }   
     return mat;
    }
}
