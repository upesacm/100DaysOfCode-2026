
import java.util.*;
class TC {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int minute = 0;
        while (!q.isEmpty()) {
            int served = q.poll();
            minute++;
            if (served == k) {
                System.out.println(minute);
                break;
            }
            if (!q.isEmpty() && q.peek() % 2 != 0) {
                int person = q.poll();
                q.offer(person);
            }
        }
    }
}