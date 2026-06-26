import java.util.Scanner;

public class Question {

    static void rotateArray(int[] arr, int k) {
        int n = arr.length;

        k = k % n;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[(i + k) % n] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            arr[i] = ans[i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        rotateArray(arr, k);

        for (int i = 0; i < num; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}