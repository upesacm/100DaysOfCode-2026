package DSA.TanmaySharma_590011578.Day_36;
import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);

        // Rotate previous elements
        int size = q.size();
        while (size > 1) {
            q.offer(q.poll());
            size--;
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}