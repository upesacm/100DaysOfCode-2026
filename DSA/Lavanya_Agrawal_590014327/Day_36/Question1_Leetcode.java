import java.util.*;

public class Question1_Leetcode {

    static class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q2.offer(x);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String operationsLine = sc.nextLine();
        String valuesLine = sc.nextLine();

        operationsLine = operationsLine.replaceAll("[\\[\\]\"]", "");
        String[] operations = operationsLine.split(",\\s*");

        List<Integer> values = new ArrayList<>();

        StringBuilder num = new StringBuilder();

        for (char ch : valuesLine.toCharArray()) {
            if (Character.isDigit(ch)) {
                num.append(ch);
            } else {
                if (num.length() > 0) {
                    values.add(Integer.parseInt(num.toString()));
                    num.setLength(0);
                }
            }
        }

        MyStack stack = new MyStack();
        int index = 0;

        System.out.print("[");

        for (int i = 0; i < operations.length; i++) {

            String op = operations[i].trim();

            switch (op) {
                case "MyStack":
                    System.out.print("null");
                    break;

                case "push":
                    stack.push(values.get(index++));
                    System.out.print("null");
                    break;

                case "pop":
                    System.out.print(stack.pop());
                    break;

                case "top":
                    System.out.print(stack.top());
                    break;

                case "empty":
                    System.out.print(stack.empty());
                    break;
            }

            if (i != operations.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
        sc.close();
    }
}