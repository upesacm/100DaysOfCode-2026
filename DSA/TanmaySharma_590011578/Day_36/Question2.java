package DSA.TanmaySharma_590011578.Day_36;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {
    public static int findServeMinute(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        int minute = 0;

        while (!queue.isEmpty()) {
            int served = queue.poll();
            minute++;

            if (served == k) {
                return minute;
            }

            if (!queue.isEmpty()) {
                int front = queue.peek();
                if (front % 2 != 0) {
                    queue.offer(queue.poll());
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        System.out.print("Enter person number to find: ");
        int k = sc.nextInt();

        int result = findServeMinute(n, k);

        System.out.println("Person " + k + " gets served at minute " + result);

        sc.close();
    }
}
