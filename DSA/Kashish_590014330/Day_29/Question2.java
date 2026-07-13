import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static void print(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String:");
        String str=sc.next();
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
        }
        String rev=" ";
        while(!str.isEmpty()){
        rev+=stack.pop();
        }
         System.out.println("Reversed String: " + rev);


    }
}