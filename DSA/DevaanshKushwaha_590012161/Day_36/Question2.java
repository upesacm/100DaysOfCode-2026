class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue2.offer(x);              // new element goes into empty queue2 first
        while (!queue1.isEmpty()) {   // drain all old elements from queue1 into queue2
            queue2.offer(queue1.poll());
        }
        // swap references: queue1 now holds everything with x at the front
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp; // queue2 becomes empty again, ready for the next push
    }
    
    public int pop() {
        return queue1.poll();
    }
    
    public int top() {
        return queue1.peek();
    }
    
    public boolean empty() {
        return queue1.isEmpty();
    }
}
