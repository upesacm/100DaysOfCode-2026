import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) 
        {
            queue.offer(i);
        }
        int min = 0;
        while (!queue.isEmpty()) 
        {

            int served = queue.poll();
            min++;
            if (served == k) 
            {
                System.out.println(min);
                return;
            }
            if (!queue.isEmpty() && queue.peek() % 2 != 0) 
            {
                queue.offer(queue.poll());
            }
        }
    }
}
