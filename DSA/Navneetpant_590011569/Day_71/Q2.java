import java.util.*;

class Solution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();


        s = s.replace(" ", "");

        int L = s.length();

        int minRows = (int) Math.floor(Math.sqrt(L));
        int maxRows = (int) Math.ceil(Math.sqrt(L));

        int rows = 0;
        int cols = 0;
        int minArea = Integer.MAX_VALUE;

        // Find grid with minimum area
        for (int r = minRows; r <= maxRows; r++) {

            int c = (int) Math.ceil((double) L / r);

            if (r * c >= L && r * c < minArea) {
                minArea = r * c;
                rows = r;
                cols = c;
            }
        }

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