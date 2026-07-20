import java.util.*;

public class Question2 {

    public static int findTime(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int time = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            time++;

            if (current == k) {
                return time;
            }

            if (!q.isEmpty()) {
                int next = q.peek();

                if (next % 2 != 0) { 
                    q.poll();       
                    q.offer(next);  
                }
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 4;

        System.out.println(findTime(n, k)); 
    }
}