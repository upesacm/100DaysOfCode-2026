import java.util.Scanner;

public class Question2 {
    public static void rotate(int[] numbers, int r) {
        int n = numbers.length;
        r = r % n;
        reverse(numbers, 0, n - 1);
        reverse(numbers, 0, r - 1);
        reverse(numbers, r, n - 1);
    }

    private static void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        int r = sc.nextInt();
        rotate(numbers, r);
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}