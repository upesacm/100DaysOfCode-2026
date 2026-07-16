package Day_29;

import java.util.*;
public class d29question1_leetcode {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||(c == '}' && top != '{') ||(c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        boolean result = isValid(a);
        System.out.println(result);
        sc.close();
    }}

