import java.util.Stack;

public class Question2 {

    public static String reverse(String s){

        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++)
            st.push(s.charAt(i));

        StringBuilder ans=new StringBuilder();

        while(!st.isEmpty())
            ans.append(st.pop());

        return ans.toString();
    }

    public static void main(String[] args){

        String s="hello";

        System.out.println(reverse(s));
    }
}