import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] temperatures, int k) {
        int n = temperatures.length;
        if (n == 0 || k <= 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices, values decreasing front-to-back
        int resultIndex = 0;

        for (int i = 0; i < n; i++) {
            // Remove indices whose values are smaller than current value
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            // Remove front index if it's out of the current window
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Record max once we have a full window
            if (i >= k - 1) {
                result[resultIndex++] = temperatures[deque.peekFirst()];
            }
        }

        return result;
    }
}
