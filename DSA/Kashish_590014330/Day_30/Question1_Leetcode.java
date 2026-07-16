import java.util.Scanner;
import java.util.Stack;

public class Question1_Leetcode {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        System.out.println("Enter String:");
        String str = sc.next();
        for (int i=0;i<str.length();i++){
            if(st.size()==0){
                st.push(str.charAt(i));
            }
            else{
                if(str.charAt(i)==st.peek()){
                    st.pop();
                }
                else{
                    st.push(str.charAt(i));
                }
            }





        }
        Stack<Character> rev = new Stack<>();

while (!st.isEmpty()) {
    rev.push(st.pop());
}


while (!rev.isEmpty()) {
    System.out.print(rev.pop());
}
    }
}