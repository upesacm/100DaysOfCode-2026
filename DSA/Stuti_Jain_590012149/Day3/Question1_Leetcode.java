import java.util.Scanner;

class Solution {

    public int[] plusOne(int[] digits) {

        int n = digits.length;

        int last = digits[n - 1];

        if (last != 9) {
            digits[n - 1] = last + 1;
            return digits;
        }

        int i = n - 1;

        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }

        if (i >= 0) {
            digits[i]++;
            return digits;
        }

        int[] newarr = new int[n + 1];
        newarr[0] = 1;

        return newarr;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        int[] digits = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            digits[i] = sc.nextInt();
        }

        int[] result = s.plusOne(digits);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
