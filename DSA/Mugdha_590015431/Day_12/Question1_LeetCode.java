package DSA.Mugdha_590015431.Day_12;
import java.util.*;
public class Question1_LeetCode {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int[] widths = new int[26];

        for(int i = 0; i < 26; i++) {
            widths[i] = sc.nextInt();
        }

        sc.nextLine();
        String s = sc.nextLine();

        int[] ans = numberOfLines(widths, s);

        System.out.println(Arrays.toString(ans));

        sc.close();
    }

    public static int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;

        for(int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a'];

            if(width + w > 100) {
                lines++;
                width = w;
            } else {
                width += w;
            }
        }

        return new int[]{lines, width};
    }
}
