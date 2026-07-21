import java.util.*;

public class Main {

    public static int ticketCounter(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        int m = 0;

        while (!q.isEmpty()) {

            m++;

            int s = q.poll();

            if (s == k) {
                return m;
            }

            if (!q.isEmpty() && q.peek() % 2 == 1) {
                q.offer(q.poll());
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println(ticketCounter(5, 4));
    }
}