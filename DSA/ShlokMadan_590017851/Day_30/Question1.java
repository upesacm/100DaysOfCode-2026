import java.util.Stack;

public class Question1 {

    public static String removeDuplicates(String s){

        Stack<Character> st=new Stack<>();

        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);

            if(!st.isEmpty() && st.peek()==ch)
                st.pop();
            else
                st.push(ch);
        }

        StringBuilder ans=new StringBuilder();

        while(!st.isEmpty())
            ans.append(st.pop());

        return ans.reverse().toString();
    }

    public static void main(String[] args){

        String s="abbaca";

        System.out.println(removeDuplicates(s));
    }
}