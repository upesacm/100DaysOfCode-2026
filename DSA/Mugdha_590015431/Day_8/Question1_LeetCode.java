package DSA.Mugdha_590015431.Day_8;
import java.util.*;
public class Question1_LeetCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(isPalindrome(s));

        sc.close();
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}