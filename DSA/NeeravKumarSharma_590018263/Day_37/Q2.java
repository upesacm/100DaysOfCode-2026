import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q2 {

    public static int getPrintTime(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        
        PriorityQueue<Integer> maxPriority = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[]{priorities[i], i});
            maxPriority.add(priorities[i]);
        }

        int minutes = 0;

        while (!queue.isEmpty()) {
            int[] currentDoc = queue.poll();

            if (currentDoc[0] < maxPriority.peek()) {
                queue.add(currentDoc);
            } else {
                minutes++;
                maxPriority.poll(); 

                if (currentDoc[1] == location) {
                    return minutes;
                }
            }
        }

        return minutes;
    }

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        System.out.println("Output: " + getPrintTime(priorities, location));
    }
}