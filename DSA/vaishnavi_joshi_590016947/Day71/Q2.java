import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().replaceAll(" ", "");

        int L = s.length();

        int rows = (int) Math.floor(Math.sqrt(L));
        int cols = (int) Math.ceil(Math.sqrt(L));

        if (rows * cols < L) {
            rows++;
        }

        StringBuilder ans = new StringBuilder();

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                int index = row * cols + col;

                if (index < L) {
                    ans.append(s.charAt(index));
                }
            }

            if (col < cols - 1) {
                ans.append(" ");
            }
        }

        System.out.println(ans);
        sc.close();
    }
}