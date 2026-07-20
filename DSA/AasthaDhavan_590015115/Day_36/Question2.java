import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) q.add(i);

        int minute = 0;

        while (true) {
            int served = q.poll();
            minute++;

            if (served == k) {
                System.out.println(minute);
                break;
            }

            if (!q.isEmpty() && q.peek() % 2 == 1)
                q.add(q.poll());
        }
    }
}