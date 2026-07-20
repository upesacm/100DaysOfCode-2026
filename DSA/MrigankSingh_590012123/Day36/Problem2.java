import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    public int ticketCounter(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int person = 1; person <= n; person++) {
            queue.offer(person);
        }

        int minute = 0;

        while (!queue.isEmpty()) {
            minute++;
            int served = queue.poll();

            if (served == k) {
                return minute;
            }

            if (!queue.isEmpty() && (queue.peek() & 1) == 1) {
                queue.offer(queue.poll());
            }
        }

        return minute;
    }
}