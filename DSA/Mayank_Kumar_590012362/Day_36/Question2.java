import java.util.Queue;
import java.util.LinkedList;
public class Question2 {
    int tc(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);
        int t = 0;
        while (true) {
            int x = q.poll();
            t++;
            if (x == k) return t;
            if (!q.isEmpty() && q.peek() % 2 == 1) q.offer(q.poll());
        }
    }
}