public class Question1_LeetCode {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            }
            else {
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();

        for (char ch : stack) {
            ans.append(ch);
        }
        return ans.reverse().toString();
    }
}
