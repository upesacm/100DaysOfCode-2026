import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    public static String actual_string(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        int i = 0;

        while (i<len) {
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            }
            else {
                if (!stack.isEmpty()) stack.pop();
            }
            i++;
        }

        StringBuilder ans = new StringBuilder();

        for (char c : stack) {
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1st string: ");
        String str1 = sc.nextLine();

        System.out.println("Enter 2nd string: ");
        String str2 = sc.nextLine();

        str1 = actual_string(str1);
        str2 = actual_string(str2);

        System.out.println("Backspace Equality exists: " + str1.equals(str2));
        sc.close();
    }
}