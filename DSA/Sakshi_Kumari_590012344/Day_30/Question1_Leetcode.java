class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int size = stack.length();

            if (size > 0 && stack.charAt(size - 1) == ch) {
                stack.deleteCharAt(size - 1);
            } else {
                stack.append(ch);
            }
        }

        return stack.toString();
    }
}
