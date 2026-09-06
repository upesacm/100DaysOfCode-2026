import java.util.*;
public class Question2 {
    public static int findUnique(Scanner sc, int n) {
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        System.out.println("The number that appears exactly once is: " + findUnique(sc, n));

        sc.close();
    }
}