import java.util.Deque;
import java.util.ArrayDeque;
public class Question2 {
    static int[] f(int[] a, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int n = a.length, j = 0;
        int[] r = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            while (!d.isEmpty() && d.peekFirst() <= i - k) d.pollFirst();
            while (!d.isEmpty() && a[d.peekLast()] <= a[i]) d.pollLast();
            d.offerLast(i);
            if (i >= k - 1) r[j++] = a[d.peekFirst()];
        } return r;
    }
}