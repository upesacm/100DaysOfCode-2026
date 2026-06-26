package DSA.Mugdha_590015431.Day_10;
import java.util.*;
public class Question1_LeetCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String haystack = sc.nextLine();
        String needle = sc.nextLine();

        System.out.println(strStr(haystack, needle));

        sc.close();
    }

    public static int strStr(String haystack, String needle) {

        for(int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;

            while(j < needle.length() &&
                  haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if(j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}