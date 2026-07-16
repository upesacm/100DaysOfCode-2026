import java.util.*;
public class Question2{
    public static void ReverseString(String s){
        Stack <Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            stack.push(s.charAt(i));
        }
        StringBuilder reversedString = new StringBuilder();
        while(!stack.isEmpty()){
            reversedString.append(stack.pop());

        }
        System.out.println("Reversed String: "+ reversedString.toString());
    }
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("Original String: "+ str);
        ReverseString(str);
        sc.close();
    }
}