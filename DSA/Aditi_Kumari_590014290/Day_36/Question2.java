/*Simulate a ticket counter queue where, after each serve, the new front person moves to the back if their number is odd, and find the minute at which person k gets served.

Example
Input: n = 4, k = 3. Output: 4. */

import java.util.*;
public class Question2 {
    public int Ticket(int n, int k){
        Queue<Integer> queue=new LinkedList<>();
        for (int i=1; i<=n; i++){
            queue.offer(i);
        }
        int min=0;
        while (!queue.isEmpty()){
            min++;
            int person=queue.poll();
            if (person == k){
                return min;
            }
            if(!queue.isEmpty() && queue.peek() %2 !=0){ 
                queue.offer(queue.poll());
            }
        }
        return -1;
    }
    
}
