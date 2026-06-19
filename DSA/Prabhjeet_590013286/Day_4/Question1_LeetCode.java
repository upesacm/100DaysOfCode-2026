class Solution {

    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                result[j][i] = matrix[i][j]; // Swapping rows and columns
            }
        }

        return result;
    }
}

//logic: transpose means converting rows into columns!!
//Element at position [i][j] moves to [j][i].
//Create a new matrix and fill it