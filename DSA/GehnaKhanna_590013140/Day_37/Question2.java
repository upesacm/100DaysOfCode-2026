import java.util.*;

public class Main {

    static class Document {
        int index;
        int priority;

        Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }

    public static int printerQueue(int[] priorities, int location) {

        Queue<Document> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Document(i, priorities[i]));
        }

        int minutes = 0;

        while (!queue.isEmpty()) {

            Document current = queue.poll();

            boolean higherPriorityExists = false;

            for (Document doc : queue) {
                if (doc.priority > current.priority) {
                    higherPriorityExists = true;
                    break;
                }
            }

            if (higherPriorityExists) {
                queue.offer(current);
            } else {
                minutes++;

                if (current.index == location) {
                    return minutes;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] priorities = new int[n];

        for (int i = 0; i < n; i++) {
            priorities[i] = sc.nextInt();
        }

        int location = sc.nextInt();

        System.out.println(printerQueue(priorities, location));
    }
}
