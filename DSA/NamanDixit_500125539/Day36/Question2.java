
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    // Function to find the minute when person k is served
    public static int ticketCounter(int n, int k) {

        // Create queue
        Queue<Integer> queue = new LinkedList<>();

        // Add people from 1 to n
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        // Minute counter
        int minute = 0;

        // Continue until queue becomes empty
        while (!queue.isEmpty()) {

            // One person is served
            minute++;

            // Remove front person
            int served = queue.poll();

            // If this is person k
            if (served == k) {
                return minute;
            }

            // Check new front person
            if (!queue.isEmpty() && queue.peek() % 2 != 0) {

                // Remove odd front person
                int person = queue.poll();

                // Send that person to the back
                queue.offer(person);
            }
        }

        // This line will never be reached
        return -1;
    }

    public static void main(String[] args) {

        // Scanner for input
        Scanner sc = new Scanner(System.in);

        // Input number of people
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        // Input person number
        System.out.print("Enter person k: ");
        int k = sc.nextInt();

        // Call function
        int answer = ticketCounter(n, k);

        // Print answer
        System.out.println("Person " + k + " gets served at minute = " + answer);

        // Close scanner
        sc.close();
    }
}
