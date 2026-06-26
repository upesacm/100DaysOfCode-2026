public class Transpose {
    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int rows = matrix.length;        
        int cols = matrix[0].length;    

        // Create transpose matrix
        int[][] transpose = new int[cols][rows];

        // Convert rows into columns
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }


        System.out.println("Transposed Matrix:");

        for (int i = 0; i < cols; i++) {
            System.out.print("[");
            for (int j = 0; j < rows; j++) {
                System.out.print(transpose[i][j]);

                if (j < rows - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}