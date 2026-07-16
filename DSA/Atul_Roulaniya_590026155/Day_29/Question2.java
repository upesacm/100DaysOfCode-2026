import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) 
        {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) 
        {
            System.out.print(stack.pop());
        }
    }
}