import java.util.Scanner;
import java.util.Stack;


public class Question1_Leetcode {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String num=sc.next();
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
        if(!st.isEmpty()){
            char top=st.peek();
            if((top=='A' && ch=='B')|| (top=='C' && ch=='D')){
                st.pop();}
            else{
                st.push(ch);


                }
            }
        else{
            st.push(ch);
        }
    }

    System.out.println(st.size());        
        
             
}
}
