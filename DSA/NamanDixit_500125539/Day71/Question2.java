
import java.util.*;

class Solution {

    // ---------------------------------------------------------
    // FUNCTION TO ENCRYPT THE STRING
    // ---------------------------------------------------------
    public String encryption(String s) {

        // Remove all spaces from the string
        s = s.replaceAll(" ", "");

        // Find length of the string
        int length = s.length();

        // Find square root of length
        int root = (int) Math.ceil(Math.sqrt(length));

        // We use root as number of columns
        int columns = root;

        // Calculate number of rows
        int rows = (int) Math.ceil((double) length / columns);

        // StringBuilder stores the final answer
        StringBuilder answer = new StringBuilder();

        // -----------------------------------------------------
        // READ COLUMN BY COLUMN
        // -----------------------------------------------------
        for (int col = 0; col < columns; col++) {

            // Read characters from this column
            for (int row = 0; row < rows; row++) {

                // Find position of character
                int index = row * columns + col;

                // Check if position exists
                if (index < length) {

                    // Add character to answer
                    answer.append(s.charAt(index));
                }
            }

            // Add space between columns
            if (col < columns - 1) {
                answer.append(" ");
            }
        }

        // Return encrypted string
        return answer.toString();
    }
}

// ---------------------------------------------------------
// DRIVER / MAIN CLASS
// ---------------------------------------------------------
public class Question2 {

    public static void main(String[] args) {

        // Scanner takes input from user
        Scanner sc = new Scanner(System.in);

        // Take the string as input
        String s = sc.nextLine();

        // Create Solution object
        Solution solution = new Solution();

        // Encrypt the string
        String result = solution.encryption(s);

        // Print the encrypted string
        System.out.println(result);

        // Close Scanner
        sc.close();
    }
}
