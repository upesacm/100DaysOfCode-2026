import java.util.*;

class Question_2 {

    public static int[] highestTemperature(int[] temperatures, int k) {

        int n = temperatures.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove elements outside current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements
            while (!deque.isEmpty() &&
                   temperatures[deque.peekLast()] <= temperatures[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            // Store maximum when first window is completed
            if (i >= k - 1) {
                result[index] = temperatures[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of temperature readings: ");
        int n = sc.nextInt();

        int[] temperatures = new int[n];

        System.out.println("Enter " + n + " temperature readings:");

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        if (k <= 0 || k > n) {
            System.out.println("Invalid window size.");
            sc.close();
            return;
        }

        int[] result = highestTemperature(temperatures, k);

        System.out.println("Highest temperatures in every window:");

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}