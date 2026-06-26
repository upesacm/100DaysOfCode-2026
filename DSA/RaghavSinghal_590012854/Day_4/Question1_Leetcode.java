class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] t = new int[n][m];
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                t[j][i] = matrix[i][j];
        return t;
    }
}