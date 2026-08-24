import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        s = s.replace(" ", "");

        int n = s.length();

        int rows = (int) Math.sqrt(n);

        while (rows * rows < n) {
            rows++;
        }

        int cols = (int) Math.ceil((double) n / rows);

        if (rows > cols) {
            int temp = rows;
            rows = cols;
            cols = temp;
        }

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {

            if (col > 0) {
                result.append(" ");
            }

            for (int row = 0; row < rows; row++) {

                int index = row * cols + col;

                if (index < n) {
                    result.append(s.charAt(index));
                }
            }
        }

        System.out.println(result);
    }
}