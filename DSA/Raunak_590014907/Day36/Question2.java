import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int servedMinute(int n, int k) {

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

            if (!queue.isEmpty() && queue.peek() % 2 != 0) {
                queue.offer(queue.poll());
            }
        }

        return -1;
    }
}