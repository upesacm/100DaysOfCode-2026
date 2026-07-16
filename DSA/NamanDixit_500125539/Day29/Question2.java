
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Input the string
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Create a Stack of characters
        Stack<Character> stack = new Stack<>();

        // Push every character into the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // StringBuilder is used to store the reversed string
        StringBuilder reversed = new StringBuilder();

        // Pop all characters from the stack
        while (!stack.isEmpty()) {

            // Remove top character and add it to the result
            reversed.append(stack.pop());
        }

        // Print the reversed string
        System.out.println("Reversed String = " + reversed);

        // Close Scanner
        sc.close();
    }
}
