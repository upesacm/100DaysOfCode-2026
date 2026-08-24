import java.util.*;

public class Main {

    public static String encrypt(String s) {

        // Remove spaces
        s = s.replace(" ", "");

        int L = s.length();

        int rows = (int) Math.floor(Math.sqrt(L));
        int columns = (int) Math.ceil((double) L / rows);

        // Ensure rows * columns >= L
        if (rows * columns < L) {
            rows++;
            columns = (int) Math.ceil((double) L / rows);
        }

        StringBuilder result = new StringBuilder();

        // Read column by column
        for (int col = 0; col < columns; col++) {

            for (int row = 0; row < rows; row++) {

                int index = row * columns + col;

                if (index < L) {
                    result.append(s.charAt(index));
                }
            }

            // Space between column strings
            if (col < columns - 1) {
                result.append(" ");
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
