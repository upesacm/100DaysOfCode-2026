import java.util.Scanner;
public class Question2 {
    static int findUnique(Scanner sc, int n) {
        int unique = 0;
        for (int i = 0; i < n; i++) {
            unique ^= sc.nextInt();
        }
        return unique;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        if (n < 1 || n > 200000 || (n & 1) == 0) {
            System.out.println("Invalid input: n must be an odd number between 1 and 200000.");
            sc.close();
            return;
        }
        System.out.println("Enter " + n + " integers:");
        int answer = findUnique(sc, n);
        System.out.println("The number that appears only once is: " + answer);
        sc.close();
    }
}