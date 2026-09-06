import java.io.*;

public class Main {

    static String encrypt(String s) {

        StringBuilder text = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                text.append(s.charAt(i));
            }
        }

        int len = text.length();

        int rows = (int) Math.sqrt(len);
        int cols;

        if (rows * rows == len) {
            cols = rows;
        } else {
            cols = rows + 1;
        }

        if (rows * cols < len) {
            rows++;
        }

        cols = (int) Math.ceil((double) len / rows);

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {

            if (col > 0) {
                result.append(' ');
            }

            for (int row = 0; row < rows; row++) {

                int index = row * cols + col;

                if (index < len) {
                    result.append(text.charAt(index));
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(encrypt(s));
    }
}