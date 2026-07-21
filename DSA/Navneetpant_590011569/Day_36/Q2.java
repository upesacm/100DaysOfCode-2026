import java.util.*;

class Q2 {

    public static int ticketCounter(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        // Add people 1 to n
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {

            // Serve the front person
            int served = queue.poll();
            minute++;

            // If target person is served
            if (served == k) {
                return minute;
            }

            // Move next front person to back if odd
            if (!queue.isEmpty() && queue.peek() % 2 != 0) {
                queue.offer(queue.poll());
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(ticketCounter(4, 3)); // 4
        System.out.println(ticketCounter(3, 1)); // 1
        System.out.println(ticketCounter(5, 4)); // 3
    }
}