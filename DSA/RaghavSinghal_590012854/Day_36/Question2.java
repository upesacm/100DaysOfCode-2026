import java.util.*;

class Solution {

    static int ticketCounter(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int minute = 0;

        while (!q.isEmpty()) {
            int person = q.poll();
            minute++;

            if (person == k) {
                return minute;
            }

            if (!q.isEmpty() && q.peek() % 2 == 1) {
                q.offer(q.poll());
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(ticketCounter(4, 3)); // 4
    }
}