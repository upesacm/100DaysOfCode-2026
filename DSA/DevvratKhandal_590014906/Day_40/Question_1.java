import java.util.*;

class Question_1 {

    static class FrontMiddleBackQueue {
        private ArrayList<Integer> queue;

        public FrontMiddleBackQueue() {
            queue = new ArrayList<>();
        }

        public void pushFront(int val) {
            queue.add(0, val);
        }

        public void pushMiddle(int val) {
            int middle = queue.size() / 2;
            queue.add(middle, val);
        }

        public void pushBack(int val) {
            queue.add(val);
        }

        public int popFront() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.remove(0);
        }

        public int popMiddle() {
            if (queue.isEmpty()) {
                return -1;
            }

            int middle = (queue.size() - 1) / 2;
            return queue.remove(middle);
        }

        public int popBack() {
            if (queue.isEmpty()) {
                return -1;
            }

            return queue.remove(queue.size() - 1);
        }

        public void display() {
            System.out.println("Queue: " + queue);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();

        System.out.print("Enter number of operations: ");
        int n = sc.nextInt();

        System.out.println(
                "Operations: pushFront, pushMiddle, pushBack, popFront, popMiddle, popBack");

        for (int i = 0; i < n; i++) {

            System.out.print("Enter operation: ");
            String operation = sc.next();

            switch (operation) {

                case "pushFront":
                    System.out.print("Enter value: ");
                    int frontValue = sc.nextInt();
                    q.pushFront(frontValue);
                    q.display();
                    break;

                case "pushMiddle":
                    System.out.print("Enter value: ");
                    int middleValue = sc.nextInt();
                    q.pushMiddle(middleValue);
                    q.display();
                    break;

                case "pushBack":
                    System.out.print("Enter value: ");
                    int backValue = sc.nextInt();
                    q.pushBack(backValue);
                    q.display();
                    break;

                case "popFront":
                    System.out.println("Removed: " + q.popFront());
                    q.display();
                    break;

                case "popMiddle":
                    System.out.println("Removed: " + q.popMiddle());
                    q.display();
                    break;

                case "popBack":
                    System.out.println("Removed: " + q.popBack());
                    q.display();
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}