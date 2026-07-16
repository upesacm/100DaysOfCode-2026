public class Question1_Leetcode{
    public int minLength(String s) {
        char[] stack = new char[s.length()];
        int top=-1;
        for(char c : s.toCharArray()){
            if (top >= 0  && ((stack[top] == 'A' && c == 'B') || (stack[top] == 'C' && c == 'D'))) {
                top--;
            } else {
                stack[++top]=c;
            }
        }
        return top+1;
    }
}