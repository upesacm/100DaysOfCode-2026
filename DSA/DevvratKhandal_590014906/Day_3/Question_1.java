import java.util.Scanner;

public class Question_1 {

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] digits = new int[n];

        System.out.println("Enter the digits:");

        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        int[] ans = plusOne(digits);

        System.out.print("Result: ");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

        sc.close();
    }
}