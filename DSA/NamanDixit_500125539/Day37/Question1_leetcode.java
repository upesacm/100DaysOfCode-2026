
import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    // Queue to store request times
    Queue<Integer> queue;

    // Constructor
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    // Return number of recent calls
    public int ping(int t) {

        // Add current request
        queue.offer(t);

        // Remove old requests
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        // Return number of recent requests
        return queue.size();
    }
}
