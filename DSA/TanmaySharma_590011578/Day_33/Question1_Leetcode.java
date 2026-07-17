package DSA.TanmaySharma_590011578.Day_33;
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int depth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) {
                    ans.append(c);
                }
                depth++;
            } else {
                depth--;
                if (depth > 0) {
                    ans.append(c);
                }
            }
        }

        return ans.toString();
    }
}