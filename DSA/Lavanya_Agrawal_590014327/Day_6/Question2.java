import java.util.*;

public class Question2 {

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

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {

            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                result.add(a[i++]);
            }
            else if (a[i] > b[j]) {
                result.add(b[j++]);
            }
            else {
                result.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < n) {

            if (i == 0 || a[i] != a[i - 1]) {
                result.add(a[i]);
            }

            i++;
        }

        while (j < m) {

            if (j == 0 || b[j] != b[j - 1]) {
                result.add(b[j]);
            }

            j++;
        }

        System.out.println(result);

        sc.close();
    }
}