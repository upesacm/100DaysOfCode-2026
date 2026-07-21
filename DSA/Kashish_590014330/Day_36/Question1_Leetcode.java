import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }

    public void push(int x) {
        q.offer(x);

        int s = q.size();

        for (int i = 0; i < s - 1; i++) {
            q.offer(q.poll());
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

public class Question1_Leetcode {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack();

        System.out.print("How many elements do you want to push? ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            stack.push(x);
        }

        System.out.println("Top element: " + stack.top());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element after pop: " + stack.top());

        System.out.println("Is stack empty? " + stack.empty());

        sc.close();
    }
}