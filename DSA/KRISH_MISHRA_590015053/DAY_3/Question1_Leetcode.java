import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] digits = new int[n];

        for(int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        boolean done = false;

        for(int i = n - 1; i >= 0; i--) {

            if(digits[i] < 9) {
                digits[i]++;
                done = true;
                break;
            }

            digits[i] = 0;
        }

        if(done) {
            for(int num : digits) {
                System.out.print(num + " ");
            }
        } else {
            System.out.print("1 ");
            for(int num : digits) {
                System.out.print(num + " ");
            }
        }

        sc.close();
    }
}
