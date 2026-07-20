import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // Add persons 1 to n
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {

            // Person at front gets ticket
            int person = queue.remove();
            minute++;

            // Check if target person got ticket
            if (person == k) {
                System.out.println(minute);
                return;
            }

            // If next front person is odd, move to back
            if (!queue.isEmpty() && queue.peek() % 2 != 0) {
                queue.add(queue.remove());
            }
        }
    }
}