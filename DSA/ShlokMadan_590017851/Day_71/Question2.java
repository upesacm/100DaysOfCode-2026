import java.util.Scanner;

public class Question2 {

    public static String encrypt(String s) {
        s = s.replace(" ", "");

        int length = s.length();
        int rows = (int)Math.floor(Math.sqrt(length));
        int columns = (int)Math.ceil(Math.sqrt(length));

        while (rows * columns < length) {
            rows++;
        }

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < columns; col++) {
            if (col > 0) {
                result.append(" ");
            }

            for (int row = col; row < length; row += columns) {
                result.append(s.charAt(row));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(encrypt(s));
    }
}