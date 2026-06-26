import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {

    public static ArrayList<Integer> merge(int[] a, int[] b, int n, int m) {
        ArrayList<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        // Merge both arrays
        while (i < n && j < m) {
            int num1 = a[i];
            int num2 = b[j];

            if (num1 == num2) {
                res.add(num1);
                i++;
                j++;
            }
            else if (num1 < num2) {
                res.add(num1);
                i++;
            }
            else {
                res.add(num2);
                j++;
            }
        }

        // Add remaining elements of first array
        while (i < n) {
            res.add(a[i]);
            i++;
        }

        // Add remaining elements of second array
        while (j < m) {
            res.add(b[j]);
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] b = new int[m];
        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> result = merge(a, b, n, m);

        System.out.println("Merged Array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}