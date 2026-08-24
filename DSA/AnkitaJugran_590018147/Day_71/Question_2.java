import java.util.Scanner;

public class GridEncryption {

    public static void main( String[] args){

        System.out.println("Enter the string to be encrypted: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //remove spaces
        str = str.replace( " ", "");  
        
        //compute length
        int Length = str.length();

        int rows = (int) Math.floor(Math.sqrt(Length));
        int cols = (int) Math.ceil(Math.sqrt(Length));

        char[][] gridmatrix = new char[rows][cols];

        //start filling the grid matrix rowwise
        int index = 0;

        for( int i = 0 ; i < rows ; i++ ){
            for ( int j = 0 ; j < cols ; j++ ){

                //to avoid index out of bounds exception, check if index is less than length of string
                if( index < Length ){
                    gridmatrix[i][j] = str.charAt(index);
                    index++;
                }
            }
        }

        //print the grid matrix
        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {

                if (gridmatrix[row][col] != '\0') {
                    result.append(gridmatrix[row][col]);
                }
            }
            result.append(" ");
        }
        System.out.println(result.toString());
    }
    
}
