import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    public static String reverse_string(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        char[] out = new char[s.length()];
        int i = 0;
        while (!stack.isEmpty()) {
            out[i++] = stack.pop();
        }
        return new String(out);
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string: ");
        String s = sc.nextLine();

        String ans = reverse_string(s);
        System.out.println("Reversed string (by using a stack): " + ans);
        sc.close();
    }
}
