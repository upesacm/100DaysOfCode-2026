// LeetCode Problem 867: Transpose Matrix

class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] new_matrix = new int[n][m];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                new_matrix[j][i] = matrix[i][j];
            }
        }
        
        return new_matrix;
    }
}
