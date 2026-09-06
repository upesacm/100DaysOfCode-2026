import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        int result = n & (n - 1);

        System.out.println("Result: " + result);
        sc.close();
    }
}