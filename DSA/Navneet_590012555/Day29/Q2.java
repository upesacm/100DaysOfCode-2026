import java.util.Stack;

class Solution {
    public String reverse(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray())
            st.push(c);

        String ans = "";

        while (!st.isEmpty())
            ans += st.pop();

        return ans;
    }
}