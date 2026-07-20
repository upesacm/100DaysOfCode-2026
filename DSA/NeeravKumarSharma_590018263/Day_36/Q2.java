import java.util.LinkedList;
import java.util.Queue;

public class Q2 {

    public static int ticketQueue(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        
        int minutes = 0;
        
        while (!queue.isEmpty()) {
            minutes++;
            
            int servedPerson = queue.poll();
            
            if (servedPerson == k) {
                return minutes;
            }
            
            if (!queue.isEmpty()) {
                int nextPerson = queue.peek();
                if (nextPerson % 2 != 0) {
                    queue.poll(); 
                    queue.add(nextPerson); 
                }
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        
        int minute = ticketQueue(n, k);
        System.out.println("Output: " + minute);
    }
}