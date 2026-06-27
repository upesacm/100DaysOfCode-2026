import java.util.*;

public class Question1_Leetcode  {

    public static int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        for (int i = 0; i < s.length(); i++) {

            int width = widths[s.charAt(i) - 'a'];

            if (currentWidth + width > 100) {
                lines++;
                currentWidth = width;
            } else {
                currentWidth += width;
            }
        }

        return new int[]{lines, currentWidth};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] widths = new int[26];

        for (int i = 0; i < 26; i++) {
            widths[i] = sc.nextInt();
        }

        sc.nextLine();

        String s = sc.nextLine();

        int[] ans = numberOfLines(widths, s);

        System.out.println(ans[0] + " " + ans[1]);

        sc.close();
    }
}