package DSA.Mugdha_590015431.Day_36;
import java.util.*;

public class Question2 {

    public static int ticketTime(int n, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {

            int person = queue.poll();
            minute++;

            if (person == k) {
                return minute;
            }

            if (!queue.isEmpty() && queue.peek() % 2 == 1) {
                queue.offer(queue.poll());
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(ticketTime(n, k));

        sc.close();
    }
}