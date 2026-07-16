import java.util.Stack;

class Solution {
    public String reverseString(String s) {
        Stack<Character> st = new Stack<>();

        // Push all characters
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        // Pop and build reversed string
        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.reverseString("hello"));
    }
}
