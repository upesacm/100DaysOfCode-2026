package Day_32;
import java.util.Stack;
class Solution {
    public int minLength(String s) {
        Stack<Character> stack =new Stack<>();
        for (int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if (!stack.isEmpty() && ((stack.peek() == 'A' && ch == 'B') ||(stack.peek() == 'C' && ch == 'D'))){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        return stack.size();
    }
}