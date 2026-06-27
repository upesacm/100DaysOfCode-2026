import java.util.*;

public class LinesToWriteString {
    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char ch : s.toCharArray()) {
            int width = widths[ch - 'a'];

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
        int[] widths = {
            10,10,10,10,10,10,10,10,10,10,
            10,10,10,10,10,10,10,10,10,10,
            10,10,10,10,10,10
        };

        String s = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }
}