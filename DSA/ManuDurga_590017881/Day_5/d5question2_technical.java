package Day_5;
import java.util.*;

public class d5question2_technical {
    public static boolean areEqual(int[] a, int[] b) {
        if (a.length != b.length) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int num : b) {
            if (!freq.containsKey(num)) return false;
            freq.put(num, freq.get(num) - 1);
            if (freq.get(num) == 0) freq.remove(num);
        }
        return freq.isEmpty();
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
    }
}
