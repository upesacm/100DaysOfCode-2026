package Day_34;

import java.util.*;
public class d34question1_leetcode {
    
    static class MyQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public MyQueue() {
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()&&!(s1.isEmpty())){
            while(!s1.isEmpty()){
                s2.push(s1.pop());   
            }
        }
        if(!s2.isEmpty()){
            return s2.pop();}
        else return -1;
            }
    
    public int peek() {
        if(s2.isEmpty()&&!(s1.isEmpty())){
            while(!s1.isEmpty()){
                s2.push(s1.pop());   
            }
        }
        if(!s2.isEmpty()){
            return s2.peek();  
        }
        else return -1;
    }
    
    public boolean empty() {
        if(s1.isEmpty()&&s2.isEmpty()){
            return true;
        }
        else return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

    public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek(); // return 1
    myQueue.pop(); // return 1, queue is [2]
    myQueue.empty(); // return false
    }
}
