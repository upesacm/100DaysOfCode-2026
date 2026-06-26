package DSA.MeghnaDhakad_590013960.Day_3;
import java.util.*;

public class Question1_Leetcode {
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

        System.out.println("Enter size of array:");
        int n = sc.nextInt();

        int[] digits = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        int[] answer = plusOne(digits);
        System.out.println(Arrays.toString(answer));
        sc.close();
    }
}