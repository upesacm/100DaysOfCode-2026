import java.util.HashMap;
import java.util.Scanner;

public class Question {

    static boolean areEqual(int[] a, int[] b) {

        if (a.length != b.length) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for (int i = 0; i < b.length; i++) {

            if (!map.containsKey(b[i])) {
                return false;
            }

            map.put(b[i], map.get(b[i]) - 1);

            if (map.get(b[i]) == 0) {
                map.remove(b[i]);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        // Input first array
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input second array
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(areEqual(a, b));

        sc.close();
    }
}

