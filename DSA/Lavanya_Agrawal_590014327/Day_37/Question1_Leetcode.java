import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question1_Leetcode {

    static class RecentCounter {
        Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);

            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            return queue.size();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String operations = sc.nextLine();

        String values = sc.nextLine();

        String[] parts = values.split("\\D+");

        RecentCounter counter = new RecentCounter();

        System.out.print("[null");

        for (String part : parts) {

            if (!part.isEmpty()) {

                int t = Integer.parseInt(part);

                int result = counter.ping(t);

                System.out.print(", " + result);
            }
        }

        System.out.println("]");

        sc.close();
    }
}