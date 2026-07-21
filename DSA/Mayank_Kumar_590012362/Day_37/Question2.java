import java.util.LinkedList;
import java.util.Queue;
public class Question2 {
    int solution(int[] p, int l) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < p.length; i++) q.offer(new int[] { p[i], i });
        int c = 0;
        while (true) {
            int[] x = q.poll();
            if (q.stream().anyMatch(a -> a[0] > x[0])) q.offer(x);
            else {
                if (++c > 0 && x[1] == l) return c;
            }
        }
    }
}
