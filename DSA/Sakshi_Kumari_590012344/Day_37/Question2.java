import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{i, priorities[i]});
        }

        int time = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            boolean hasHigher = false;

            for (int[] doc : queue) {
                if (doc[1] > current[1]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                queue.offer(current);
            } else {
                time++;
                if (current[0] == location) {
                    return time;
                }
            }
        }

        return -1;
    }
}
