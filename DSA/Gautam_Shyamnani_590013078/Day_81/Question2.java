import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ones = 0;
        int twos = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        System.out.println(ones);

        sc.close();
    }
}