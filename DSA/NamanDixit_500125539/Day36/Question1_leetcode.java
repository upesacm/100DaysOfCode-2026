
import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    // Main queue
    Queue<Integer> q1 = new LinkedList<>();

    // Temporary queue
    Queue<Integer> q2 = new LinkedList<>();

    // Push element
    public void push(int x) {

        // Add new element
        q2.offer(x);

        // Move all old elements
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop element
    public int pop() {

        return q1.poll();
    }

    // Return top element
    public int top() {

        return q1.peek();
    }

    // Check empty
    public boolean empty() {

        return q1.isEmpty();
    }
}
