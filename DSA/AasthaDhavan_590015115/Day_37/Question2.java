import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        int[] p = {2, 1, 3, 2};
        int loc = 2, ans = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < p.length; i++) q.offer(i);

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (Collections.max(Arrays.stream(q.toArray(new Integer[0]))
                    .map(i -> p[i]).toList()) > p[cur]) {
                q.offer(cur);
            } else {
                ans++;
                if (cur == loc) break;
            }

            if (q.isEmpty() && cur != loc) break;
        }

        System.out.println(ans);
    }
}