import java.util.Scanner;
public class Question2 {
    public static int mostSetBit(int n) {
        return n & (n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.println("Result after turning off the rightmost set bit: " + mostSetBit(n));
        sc.close();
    }
}