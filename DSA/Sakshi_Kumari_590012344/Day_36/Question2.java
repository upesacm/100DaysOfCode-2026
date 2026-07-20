import java.util.*;

public class TicketCounterQueue {

    public static int servedMinute(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {
            minute++;
            int person = queue.poll();

            if (person == k) {
                return minute;
            }

            if (person % 2 != 0) {
                queue.offer(person);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        System.out.println(servedMinute(n, k));
    }
}
