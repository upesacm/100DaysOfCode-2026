import java.util.Arrays;

public class Question1 {

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

        int[] widths = new int[26];
        Arrays.fill(widths, 10);

        String s = "abcdefghijklmnopqrstuvwxyz";

        int[] ans = numberOfLines(widths, s);

        System.out.println(Arrays.toString(ans));
    }
}