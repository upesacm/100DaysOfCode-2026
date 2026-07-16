class Solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int n = stack.length();

            if (n > 0) {
                char top = stack.charAt(n - 1);

                if ((top == 'A' && ch == 'B') ||
                    (top == 'C' && ch == 'D')) {
                    stack.deleteCharAt(n - 1);
                    continue;
                }
            }

            stack.append(ch);
        }

        return stack.length();
    }
}
