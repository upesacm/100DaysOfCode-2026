import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {
            int served = queue.poll();
            minute++;

            if (served == k) {
                System.out.println(minute);
                break;
            }

            if (!queue.isEmpty() && queue.peek() % 2 != 0) {
                queue.add(queue.poll());
            }
        }

        sc.close();
    }
}