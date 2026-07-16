/*Reverse the given string using a stack and print the reversed string.

Example
Input:s = hello. Output:olleh */

import java.util.*;
public class Question2 {
    public String revStr(String s){
        Stack <Character> stack =new Stack<>();
        for (int i=0; i< s.length(); i++){
            stack.push(s.charAt(i));
        }
        StringBuilder ans= new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
