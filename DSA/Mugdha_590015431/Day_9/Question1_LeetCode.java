package DSA.Mugdha_590015431.Day_9;
import java.util.*;
public class Question1_LeetCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(lengthOfLastWord(s));

        sc.close();
    }

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Count characters of last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}