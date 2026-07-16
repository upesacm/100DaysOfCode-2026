public class Q1_leetcode {

    public int minLength(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && ((stack[top] == 'A' && c == 'B') || (stack[top] == 'C' && c == 'D'))) {
                top--;
            } else {
                stack[++top] = c;
            }
        }

        return top + 1;
    }

    public static void main(String[] args) {
        Q1_leetcode sol = new Q1_leetcode();

        System.out.println(sol.minLength("ABFCACDB")); // 2
        System.out.println(sol.minLength("ACBBD"));     // 5
    }
}