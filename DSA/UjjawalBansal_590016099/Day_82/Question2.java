import java.util.Scanner;

public class Question2 {
    public static int turnOffRightmostSetBit(int n) {
        return n & (n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        
        int ans = turnOffRightmostSetBit(n);
        System.out.println(ans);
        sc.close();
    }
}