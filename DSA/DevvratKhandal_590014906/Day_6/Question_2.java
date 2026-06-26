import java.util.ArrayList;
import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {

            if (a[i] < b[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i])
                    ans.add(a[i]);
                i++;
            }

            else if (a[i] > b[j]) {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j])
                    ans.add(b[j]);
                j++;
            }

            else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i])
                    ans.add(a[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != a[i])
                ans.add(a[i]);
            i++;
        }

        while (j < m) {
            if (ans.size() == 0 || ans.get(ans.size() - 1) != b[j])
                ans.add(b[j]);
            j++;
        }

        System.out.println(ans);
    }
}