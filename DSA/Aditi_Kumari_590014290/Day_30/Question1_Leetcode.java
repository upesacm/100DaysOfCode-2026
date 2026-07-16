package Day_30;
import java.util.*;
class Solution {
    public String removeDuplicates(String s) {
       Stack<Character> stack=new Stack<>();
       for (int i=0; i<s.length(); i++){
        if (stack.isEmpty() || stack.peek() != s.charAt(i)){
            stack.push(s.charAt(i));
       }
       else{
        stack.pop();
       } 
       }
       StringBuilder str = new StringBuilder();
       while (!stack.isEmpty()){
        str.insert(0,stack.pop());
       }
       return str.toString();
    }
}