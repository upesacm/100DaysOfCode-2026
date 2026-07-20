import java.util.ArrayDeque;
import java.util.Queue;

class Question1_LeetCode {
    // This is the costly push way by using only one queue where push() operation takes O(n) time and pop() and top() takes O(1) time.
    class MyStackCostlyPush {
        Queue<Integer> q1;

        public MyStackCostlyPush() {
            q1 = new ArrayDeque<>();
        }
        
        public void push(int x) {
            q1.offer(x);
            int temp = q1.size() - 1;
            for (int i = 0; i < temp; i++) {
                q1.offer(q1.poll());
            }
        }
        
        public int pop() {
            return q1.poll();
        }
        
        public int top() {
            return q1.peek();
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    // This is the costly pop way by using only one queue where pop() and top() operations takes O(n) time and push() operation takes O(1) time.
    class MyStackCostlyPop {
        Queue<Integer> q1;

        public MyStackCostlyPop() {
            q1 = new ArrayDeque<>();
        }
        
        public void push(int x) {
            q1.offer(x);
        }
        
        public int pop() {
            int size = q1.size() - 1;
            for(int i = 0; i < size; i++) {
                q1.offer(q1.poll());
            }
            return q1.poll();
        }
        
        public int top() {
            int size = q1.size() - 1;
            for(int i = 0; i < size; i++) {
                q1.offer(q1.poll());
            }
            int temp = q1.peek();
            q1.offer(q1.poll());
            return temp;
        }
        
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}