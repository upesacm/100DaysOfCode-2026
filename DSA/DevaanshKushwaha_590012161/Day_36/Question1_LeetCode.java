class MyStack {
    private Queue<Integer> queue;
    
    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = queue.size();
        queue.offer(x); // add new element to the back, as any queue push would
        
        // Rotate: move every element that was already in the queue
        // from front to back, so 'x' ends up at the front
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll()); // pop from front, push it to back
        }
        // After this loop, x sits at the front -> acts as the stack's "top"
    }
    
    public int pop() {
        return queue.poll(); // front is always the most recent push -> remove & return it
    }
    
    public int top() {
        return queue.peek(); // front is always the most recent push -> just look
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
