import java.util.*;

public class Question2 {

    public static String encrypt(String s) {
        // Remove spaces
        String text = s.replaceAll(" ", "");
        int length = text.length();

        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));

        // Find the grid with minimum area
        while (rows * cols < length) {
            rows++;
            cols = (int) Math.ceil((double) length / rows);
        }

        StringBuilder result = new StringBuilder();

        // Read column-wise
        for (int col = 0; col < cols; col++) {
            if (result.length() > 0) {
                result.append(" ");
            }

            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;

                if (index < length) {
                    result.append(text.charAt(index));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(encrypt(s));

        sc.close();
    }
}