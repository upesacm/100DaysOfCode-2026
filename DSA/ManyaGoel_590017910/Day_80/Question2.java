import java.util.Scanner;
public class Question2{
    public static boolean checkNumber(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the integer: ");
        int n = sc.nextInt();
        System.out.println("Result: " + checkNumber(n));
        sc.close();
    }
}