import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().replace(" ", "");
        int L = s.length();

        int rows = (int) Math.floor(Math.sqrt(L));

        while (rows * (int) Math.ceil((double) L / rows) < L) {
            rows++;
        }

        int cols = (int) Math.ceil((double) L / rows);

        StringBuilder result = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            if (col > 0) {
                result.append(" ");
            }

            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;

                if (index < L) {
                    result.append(s.charAt(index));
                }
            }
        }

        System.out.println(result);
    }
}
