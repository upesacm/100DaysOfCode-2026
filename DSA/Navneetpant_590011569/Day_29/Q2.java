import java.util.Stack;
class Solution {
    public static String reverseString ( String temp ) {
        Stack <Character> stack = new Stack<>();

        for (int i = 0 ; i < temp.length() ; i++ ) {
            stack.push(temp.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty() ) {
            sb.append(stack.pop());
        }
        return sb.toString();
       


       
    }
}
public class Q2{
    public static void main(String[] args) {
        String temp1 = "Hello";
        System.out.println(Solution.reverseString(temp1));
        String temp2 = "Stack";
        System.out.println(Solution.reverseString(temp2));
    }
}