import java.util.*;

public class Question1_Leetcode{

    public static int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int length = 0;
        
        // Count characters of last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(lengthOfLastWord(s));

        sc.close();
    }
}