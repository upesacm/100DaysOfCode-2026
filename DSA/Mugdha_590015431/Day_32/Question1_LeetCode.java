package DSA.Mugdha_590015431.Day_32;

import java.util.*;

public class Question1_LeetCode {

    public static int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = stack.length();

            if (len > 0 &&
                ((stack.charAt(len - 1) == 'A' && ch == 'B') ||
                 (stack.charAt(len - 1) == 'C' && ch == 'D'))) {

                stack.deleteCharAt(len - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(minLength(s));

        sc.close();
    }
}