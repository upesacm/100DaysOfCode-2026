import java.util.*;

class Question_2 {

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = sc.nextLine();

        String reversed = reverseString(s);

        System.out.println("Reversed string is: " + reversed);

        sc.close();
    }
}