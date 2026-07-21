import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int minute = 0;

        while (!q.isEmpty()) {

            int person = q.poll();
            minute++;

            if (person == k) {
                System.out.println("Minute = " + minute);
                break;
            }

            if (!q.isEmpty() && q.peek() % 2 != 0) {
                q.offer(q.poll());
            }
        }
    }
}