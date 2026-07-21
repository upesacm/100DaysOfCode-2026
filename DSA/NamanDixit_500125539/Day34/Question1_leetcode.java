import java.util.Stack;

class MyQueue {

    // Stack for inserting
    Stack<Integer> stack1;

    // Stack for removing
    Stack<Integer> stack2;

    // Constructor
    public MyQueue() {

        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element
    public void push(int x) {

        stack1.push(x);
    }

    // Remove front element
    public int pop() {

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Return front element
    public int peek() {

        if (stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    // Check empty
    public boolean empty() {

        return stack1.isEmpty() && stack2.isEmpty();
    }
}