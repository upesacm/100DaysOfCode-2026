package DSA.Mugdha_590015431.Day_5;

import java.util.*;

public class Question2 {

    public static boolean areEqual(int[] a, int[] b) {

        if (a.length != b.length) {
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : b) {

            if (!map.containsKey(num)) {
                return false;
            }

            map.put(num, map.get(num) - 1);

            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        System.out.println(areEqual(a, b));

        sc.close();
    }
}