import java.util.Arrays;
import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of arrays: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        boolean equal = true;

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                equal = false;
                break;
            }
        }

        System.out.println(equal);
    }
}