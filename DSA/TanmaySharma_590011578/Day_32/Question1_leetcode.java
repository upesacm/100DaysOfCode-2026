package DSA.TanmaySharma_590011578.Day_32;
class solution {
    public int minLength(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = stack.length();

            if (n > 0 &&
                ((stack.charAt(n - 1) == 'A' && c == 'B') ||
                 (stack.charAt(n - 1) == 'C' && c == 'D'))) {
                stack.deleteCharAt(n - 1); // Pop
            } else {
                stack.append(c); // Push
            }
        }

        return stack.length();
    }
}