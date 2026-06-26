import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine();
        String reversed = new StringBuilder(str).reverse().toString();

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reversed);
        in.close();
    }
}

