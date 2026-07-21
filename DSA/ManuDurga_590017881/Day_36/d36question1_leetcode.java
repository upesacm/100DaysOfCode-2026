package Day_36;

import java.util.*;
public class d36question1_leetcode {
    
    static class MyStack {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
    
        public MyStack() {
        }
    
        public void push(int x) {
            q1.add(x);
        }
    
        public int pop() {
            if (q1.isEmpty()) return -1;
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int top = q1.remove();
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return top;
        }
    
        public int top() {
            if (q1.isEmpty()) return -1;
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            int top = q1.peek();
            q2.add(q1.remove());  
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            return top;
        }
    
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    
    public static void main(String[] args) {
    MyStack mystack = new MyStack();
    mystack.push(1); // queue is: [1]
    mystack.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    mystack.top(); // return 1
    mystack.pop(); // return 1, queue is [2]
    mystack.empty(); // return false
    }
}
