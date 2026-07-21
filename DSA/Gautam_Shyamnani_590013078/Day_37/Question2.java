import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> q = new LinkedList<>();
        
        for (int p : priorities) {
            q.offer(p);
        }

        int time = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            boolean hasHigher = false;
            for (int x : q) {
                if (x > current) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.offer(current); 

                if (location == 0) {
                    location = q.size() - 1;
                } else {
                    location--;
                }
            } else {
                time++; 

                if (location == 0) {
                    return time;
                } else {
                    location--;
                }
            }
        }

        return time;
    }
}

public class Question2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] priorities = {1,1,9,1,1,1};
        int location = 0;

        int result = sol.solution(priorities, location);
        System.out.println(result);
    }
}