package Day_36;

import java.util.*;

public class d36question2_technical {
public static int ticketCounter(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Initialize queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {
            // Serve the front person
            int served = queue.remove();
            minute++;

            if (served == k) {
                return minute;
            }

            // Move the next odd-numbered person to the back
            if (!queue.isEmpty() && queue.peek() % 2 != 0) {
                queue.offer(queue.remove());
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ticketCounter(4, 3)); // 4
        System.out.println(ticketCounter(3, 1)); // 1
        System.out.println(ticketCounter(5, 4)); // 3
    }}