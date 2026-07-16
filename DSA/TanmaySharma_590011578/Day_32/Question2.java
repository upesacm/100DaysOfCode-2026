package DSA.TanmaySharma_590011578.Day_32;
import java.util.Scanner;
import java.util.Stack;

class MyStack {
    private Stack<Integer> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        stack.push(value);
    }

    public int pop() {
        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.print("[");
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
            if (i < stack.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        MyStack original = new MyStack();
        MyStack temp = new MyStack();
        MyStack copy = new MyStack();

        for (int i = 0; i < n; i++) {
            original.push(sc.nextInt());
        }

        while (!original.isEmpty()) {
            temp.push(original.pop());
        }

        while (!temp.isEmpty()) {
            int value = temp.pop();
            original.push(value);
            copy.push(value);
        }

        copy.display();
    }
}