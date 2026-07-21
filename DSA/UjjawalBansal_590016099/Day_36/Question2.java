import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    public static int serviceTime(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        
        int curr = 0;
        
        while (!queue.isEmpty()) {
            curr++;
            
            int served = queue.poll();
            
            if (served == k) return curr;
            
            if (!queue.isEmpty()) {
                int next = queue.peek();
                
                if (next % 2 != 0) {
                    queue.offer(queue.poll());
                }
            }
        }
        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of person in queue: ");
        int n = sc.nextInt();

        System.out.println("Enter the target person: ");
        int k = sc.nextInt();
        
        int time = serviceTime(n, k);
        System.out.println("The target person was served at minute: " + time);
        sc.close();
    }
}