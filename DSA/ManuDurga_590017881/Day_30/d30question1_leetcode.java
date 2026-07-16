package Day_30;

import java.util.*;
public class d30question1_leetcode {
    
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(stack.empty()) stack.push(c);
            else if(stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        StringBuilder a = new StringBuilder();
        for(char c : stack) a.append(c);
        
        return a.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(removeDuplicates(sc.nextLine()));
        sc.close();
    }
}
