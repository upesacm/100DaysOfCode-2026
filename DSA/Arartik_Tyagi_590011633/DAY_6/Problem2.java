import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        ArrayList<Integer> union = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else if (a[i] > b[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
                    union.add(b[j]);
                }
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }

        System.out.println(union);
        sc.close();
    }
}