import java.util.Scanner;

public class Question2 {
    public static boolean powerOfZeroOrTwo(int n) {
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        
        boolean ans = powerOfZeroOrTwo(n);
        System.out.println(ans);
        sc.close();
    }
}