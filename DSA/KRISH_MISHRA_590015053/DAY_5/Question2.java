import java.util.Arrays;
import java.util.Scanner;

public class CheckEqualArrays {

    public static boolean areEqual(int[] a, int[] b) {

        if (a.length != b.length) {
            return false;
        }

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of arrays: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        System.out.println("Enter first array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("Enter second array:");
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(areEqual(a, b));

        sc.close();
    }
}
