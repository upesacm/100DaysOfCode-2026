package Day_37;
import java.util.*;
class RecentCounter {
    Queue <Integer> queue=new ArrayDeque<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        queue.offer(t);
        while (!queue.isEmpty() && t-queue.peek() > 3000){
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */