import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private final Queue<Integer> first;
    private final Queue<Integer> second;

    public MyStack() {
        first = new LinkedList<>();
        second = new LinkedList<>();
    }

    public void push(int x) {
        second.offer(x);
        while (!first.isEmpty()) {
            second.offer(first.poll());
        }

        Queue<Integer> temporary = first;
        first.clear();
        first.addAll(second);
        second.clear();
    }

    public int pop() {
        return first.poll();
    }

    public int top() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }
}