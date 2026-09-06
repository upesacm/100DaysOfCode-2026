import java.util.Scanner;

public class Question2 {
    public static int findNumberOfSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        
        int ans = findNumberOfSetBits(n);
        System.out.println(ans);
        sc.close();
    }
}
