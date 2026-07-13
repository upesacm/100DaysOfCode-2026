import java.util.Stack;

public class ReverseString {

    public static void main(String[] args){

        String str = "Hello";
        System.out.println("Original String: " + str);

        Stack<Character> stack = new Stack<>();

        for( int i = 0 ; i < str.length() ; i++ ){

            stack.push(str.charAt(i));

        }

        StringBuilder rev_str = new StringBuilder();

        while( stack.isEmpty() == false ){

            rev_str.append(stack.pop());

        }

        System.out.println("Reversed String: " + rev_str);
    }
}