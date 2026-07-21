/*Simulate a priority-based printer queue to determine how many minutes it takes for a document at a given position to be printed.

Example
Input: priorities = [2, 1, 3, 2], location = 2. Output: 1. */
package Day_37;
import java.util.*;
public class Question2 {
    public int Priority(int[] priorities, int location) {

        Queue<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
            maxHeap.offer(priorities[i]);
        }
        int count = 0;
        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            if (curr[1] == maxHeap.peek()) {
                count++;
                maxHeap.poll();
                if (curr[0] == location) {
                    return count;
                }
            } else {
                queue.offer(curr);
            }
        }
        return -1;
}
}
