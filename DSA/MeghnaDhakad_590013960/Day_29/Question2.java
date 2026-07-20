public class Question2 {

    public static String reverse(String s) {

        char[] stack = new char[s.length()];
        int top = -1;

        // Push all characters
        for (int i = 0; i < s.length(); i++) {
            stack[++top] = s.charAt(i);
        }

        StringBuilder reversed = new StringBuilder();

        // Pop all characters
        while (top >= 0) {
            reversed.append(stack[top--]);
        }

        return reversed.toString();
    }

    public static void main(String[] args) {

        String s = "hello";

        System.out.println(reverse(s));
    }
}